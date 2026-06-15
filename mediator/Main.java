// package mediator;

// interface chatMediator{
//   void sendMessage(String message ,User user);
// }

// class ChatRoom implements ChatMediator{

//   private List<user> users = new ArrayList<>();

//   public void addUser(User user){
//     users.add(user);
//   }

//   public void sendMessage(String message, User sender){
//     for(User user: users){
//       if(user != sender){
//         user.receive(message);
//       }
//     }
//   }
// }


// class User {

//     private String name;
//     private ChatMediator mediator;

//     public User(String name, ChatMediator mediator) {
//         this.name = name;
//         this.mediator = mediator;
//     }

//     public String getName(){
//       return name;
//     }

//     public void send ( String message){
//       System.out.println(name + "sends: "+ message);
//       mediator.sendMessage(message, this);
//     }
   

//     public void receiveMessage(String message) {
//         System.out.println(name +
//                 " received : " + message);
//     }
// }

// public class Main {

//     public static void main(String[] args) {

//         User rahim = new User("Rahim");
//         User karim = new User("Karim");
//         User jamil = new User("Jamil");

//         rahim.sendMessage(karim, "Hello Karim");

//         karim.sendMessage(jamil, "Hello Jamil");

//     }

// }