// package State;

// interface State{
//   void insertCard(ATM context , String card);
//   void insertPin(ATM context,String password);
//   void withdrawMoney(ATM context, int money);
//   void ejectCard(ATM context);
// }

// class NO_CARDState implements State{
//   @Override
//   public void insertCard(ATM context, String card) {
//     System.out.println(card + " Inserted");
//     context.setState(new HAS_CARDState());
//   }
//   public void insertPin(ATM context,String password){
//     System.out.println("Enter card first");
//   }
//   public void withdrawMoney(ATM context, int money){
//     System.out.println("Enter card first");
//   }
//   public void ejectCard(ATM context){
//     System.out.println("Enter card first");
//   }
// }

// class HAS_CARDState implements State{
//   public void insertCard(ATM context , String card){
//     System.out.println("Already have card");
//   }
//   public void insertPin(ATM context,String password){
//     System.out.println("Password verified");
//     context.setState(new AUTHENTICATEDState());
//   }
//   public void withdrawMoney(ATM context, int money){
//     System.out.println("enter pin first");
//   }
//   public void ejectCard(ATM context){
//     System.out.println("Ejected Successfully");
//     context.setState(new NO_CARDState());
//   }
// }

// class AUTHENTICATEDState implements State{
//    public void insertCard(ATM context , String card){
//     System.out.println("Already have card");
//   }
//   public void insertPin(ATM context,String password){
//     System.out.println("already verified.");
//   }
//   public void withdrawMoney(ATM context, int money){
//     System.out.println("Withdraw money successfully "+ money);
//     context.setState(new NO_CARDState());
//   }
//   public void ejectCard(ATM context){
//     System.out.println("Ejected Successfully");
//     context.setState(new NO_CARDState());
//   }

// }




// class ATM {

//     private State state ;

//     public ATM(){
//       this.state = new NO_CARDState();
//     }
//     public void setState(State state){
//       this.state = state;
//     }
//     public void insertCard( String card){
//       state.insertCard(this, card);
//     }
//     public void insertPin(String password){
//       state.insertPin(this, password);
//     }
//     public void withdrawMoney( int money){
//       state.withdrawMoney(this,money);
//     }
//     public void ejectCard(){
//       state.ejectCard(this);
//     }

// }

// public class Main {

//     public static void main(String[] args) {

//         ATM atm = new ATM();
//         atm.insertCard("Islami Bank card");
//         atm.ejectCard();
//         atm.insertCard("shahjalal islami bank card");
//         atm.withdrawMoney(5000);
//         atm.insertPin("3456");
//         atm.withdrawMoney(4000);
        
//     }
// }