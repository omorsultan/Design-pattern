package adapter.NotificationHard;


interface Notification{
  void send();
}
// আমাদের অ্যাপের নিজস্ব নোটিফিকেশন সিস্টেম (যা শুধু ইমেইল পাঠাতে পারে)
class CoreNotification {
    public void send(String userId, String message) {
        System.out.println("Sending Core App Notification to User " + userId + ": " + message);
    }
}

// থার্ড-পার্টি লাইব্রেরি ১: এডভান্সড SMS সার্ভিস (মেথড ও প্যারামিটার আলাদা!)
class AdvancedSmsService {
    // এখানে userId এর বদলে লাগে phoneNo, আর মেথডের নাম pushSms
    public void pushSms(String phoneNo, String textMessage) {
        System.out.println("SMS sent via Third-Party to " + phoneNo + ": " + textMessage);
    }
}

// থার্ড-পার্টি লাইব্রেরি ২: সেন্ডগ্রিড ইমেইল সার্ভিস (মেথডের নাম এবং প্যারামিটার সিকোয়েন্স আলাদা!)
class SendGridEmailService {
    // এখানে প্রথমে মেসেজ, তারপর ইমেইল এড্রেস দিতে হয়। মেথডের নাম sendMail
    public void sendMail(String content, String emailAddress) {
        System.out.println("Email sent via SendGrid to " + emailAddress + ": " + content);
    }
}


// ক্লায়েন্ট কোড (এখানেই আসল জগাখিচুড়ি!)
public class Main {
    public static void main(String[] args) {
        String userId = "USR101";
        String userPhone = "+8801700000000";
        String userEmail = "user@example.com";
        String notificationMessage = "Your OTP is 1234";

        // নোটিফিকেশন টাইপ অনুযায়ী ক্লায়েন্টকে সিদ্ধান্ত নিতে হচ্ছে
        String serviceType = "SMS"; // এটি "CORE", "SMS" বা "EMAIL" হতে পারে

        // মেসি পার্ট: ক্লায়েন্ট কোডকে প্রতিটা থার্ড-পার্টি ক্লাসের ইন্টারনাল মেথডের নাম, 
        // প্যারামিটারের উল্টোপাল্টা সিকোয়েন্স মুখস্থ রেখে if-else এর জঙ্গল বানাতে হচ্ছে।
        if (serviceType.equals("CORE")) {
            CoreNotification core = new CoreNotification();
            core.send(userId, notificationMessage); // স্ট্যান্ডার্ড মেথড
            
        } else if (serviceType.equals("SMS")) {
            AdvancedSmsService smsService = new AdvancedSmsService();
            // ঝামেলা ১: মেথডের নাম আলাদা (pushSms) এবং আইডি'র বদলে ফোন নম্বর পাস করতে হচ্ছে
            smsService.pushSms(userPhone, notificationMessage);
            
        } else if (serviceType.equals("EMAIL")) {
            SendGridEmailService emailService = new SendGridEmailService();
            // ঝামেলা ২: মেথডের নাম আলাদা (sendMail) এবং প্যারামিটারের সিকোয়েন্স উল্টো! (প্রথমে মেসেজ, তারপর ইমেইল)
            emailService.sendMail(notificationMessage, userEmail);
        }
    }
}