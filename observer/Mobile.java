package observer;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(int temp);
}

class MobileApp implements Observer {
    public void update(int temp) {
        System.out.println("Mobile App: Temperature = " + temp);
    }
}

class LEDDisplay implements Observer {
    public void update(int temp) {
        System.out.println("LED Display: Temperature = " + temp);
    }
}

interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    
}

class WeatherStation implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private int temp;

    public void registerObserver(Observer observer){
        observers.add(observer);
    }
   
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(temp);
        }
    }

    public void setTemperature(int temp){
        this.temp = temp;
        System.out.println("New temperature is :" + temp);
        notifyObservers();
    } 
    
}

public class Mobile {
    public static void main(String[] args) {


        WeatherStation bdWeather = new WeatherStation();
        Observer mobie1 = new MobileApp();
        Observer led1 = new LEDDisplay();

        bdWeather.registerObserver(mobie1);
        bdWeather.registerObserver(led1);

        int temp = 25;
        bdWeather.setTemperature(temp);
       
    }
}