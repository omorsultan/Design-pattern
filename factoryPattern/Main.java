package factoryPattern;

abstract class Notification {
    abstract void send();
}

class EmailNotification extends Notification {
   void send(){
    System.out.println("Email sent");
   }
}

class SMSNotfication extends Notification{
    void send(){
        System.out.println("SMS sent");
    }
}

class NotificationFactory{
    public static  Notification createNotification(String type){
        if (type.equalsIgnoreCase("email")){
            return new EmailNotification();
        }
        if (type.equalsIgnoreCase("sms")){
            return new SMSNotfication();
        }
        
        throw new IllegalArgumentException("Invalid Notification type");
    }
}
public class Main {

    public static void notifyUser(String type){
        Notification notification = NotificationFactory.createNotification(type);
        notification.send();
    }
    public static void main(String[] args) {
       notifyUser("email");
       notifyUser("sms");
    }
}
