package adapter.Notification;

 interface Message{
  void sendMessage(String message);
}
class EmailService {

    public void sendEmail(String message) {
        System.out.println("Email: " + message);
    }
}



class WhatsAppService {

    public void sendWhatsAppMessage(String message) {
        System.out.println("WhatsApp: " + message);
    }
}
class WhatsAppAdapter implements Message{
    private WhatsAppService whatsAppService;

    public WhatsAppAdapter(WhatsAppService whatsAppService){
        this.whatsAppService = whatsAppService;
    }

    @Override
    public void sendMessage(String messsage) {
        whatsAppService.sendWhatsAppMessage( messsage);
    }
}

class EmailAdapter implements Message{

    private EmailService emailService;

    public EmailAdapter (EmailService emailService){
        this.emailService= emailService;
    }

    @Override
    public void sendMessage(String messsage) {
        emailService.sendEmail( messsage);
    }


}

public class Main {

    public static void main(String[] args) {

        String message = "Welcome to Dakdao";

        Message email = new EmailAdapter(new EmailService());
        email.sendMessage(message);


        Message whatsapp = new WhatsAppAdapter(new WhatsAppService());
        whatsapp.sendMessage(message);
    }
}
