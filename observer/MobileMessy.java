// package observer;
// class MobileApp {
//     public void update(int temp) {
//         System.out.println("Mobile App: Temperature = " + temp);
//     }
// }

// class LEDDisplay {
//     public void update(int temp) {
//         System.out.println("LED Display: Temperature = " + temp);
//     }
// }

// class WeatherStation {
//     private int temperature;

//     private MobileApp mobileApp;
//     private LEDDisplay ledDisplay;

//     public WeatherStation(MobileApp mobileApp, LEDDisplay ledDisplay) {
//         this.mobileApp = mobileApp;
//         this.ledDisplay = ledDisplay;
//     }

//     public void setTemperature(int temperature) {
//         this.temperature = temperature;

//         // Direct notification
//         mobileApp.update(temperature);
//         ledDisplay.update(temperature);
//     }
// }

// public class MobileMessy {
//     public static void main(String[] args) {

//         MobileApp mobile = new MobileApp();
//         LEDDisplay led = new LEDDisplay();

//         WeatherStation station =
//                 new WeatherStation(mobile, led);

//         station.setTemperature(30);
//     }
// }