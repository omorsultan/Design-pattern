package singleton.logger;


class Logger {

    private static Logger instance ;

    private Logger(){
        System.out.println("Logger initialized.");
    }
    public static Logger getInstance() {
       if(instance == null ){
        instance = new Logger();
       }
       return instance;
    }
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class UserService {

    private Logger logger = Logger.getInstance();

    public void registerUser() {
        logger.log("User Registered");
    }
}

class PaymentService {

    private Logger logger = Logger.getInstance();

    public void processPayment() {
        logger.log("Payment Processed");
    }
}

class OrderService {

    private Logger logger = Logger.getInstance();

    public void createOrder() {
        logger.log("Order Created");
    }
}

class NotificationService {

    private Logger logger = Logger.getInstance();

    public void sendNotification() {
        logger.log("Notification Sent");
    }
}

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService();
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService();
        NotificationService notificationService = new NotificationService();

        userService.registerUser();
        paymentService.processPayment();
        orderService.createOrder();
        notificationService.sendNotification();
    }
}