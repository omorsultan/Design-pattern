package bridge.TV;


// ==========================
// Implementation
// ==========================
interface TV {
    void turnOn();
    void turnOff();
}

class SamsungTV implements TV {

    @Override
    public void turnOn() {
        System.out.println("Samsung TV ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Samsung TV OFF");
    }
}

class SonyTV implements TV {

    @Override
    public void turnOn() {
        System.out.println("Sony TV ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony TV OFF");
    }
}

class LGTV implements TV {

    @Override
    public void turnOn() {
        System.out.println("LG TV ON");
    }

    @Override
    public void turnOff() {
        System.out.println("LG TV OFF");
    }
}

// ==========================
// Abstraction
// ==========================
abstract class Remote {

    protected TV tv;

    public Remote(TV tv) {
        this.tv = tv;
    }

    abstract void powerOn();

    abstract void powerOff();
}

// ==========================
// Refined Abstractions
// ==========================
class BasicRemote extends Remote {

    public BasicRemote(TV tv) {
        super(tv);
    }

    @Override
    void powerOn() {
        tv.turnOn();
    }

    @Override
    void powerOff() {
        tv.turnOff();
    }
}

class SmartRemote extends Remote {

    public SmartRemote(TV tv) {
        super(tv);
    }

    @Override
    void powerOn() {
        System.out.println("Smart Remote:");
        tv.turnOn();
    }

    @Override
    void powerOff() {
        System.out.println("Smart Remote:");
        tv.turnOff();
    }

    public void voiceControl() {
        System.out.println("Voice Control Activated");
    }
}

class VoiceRemote extends Remote {

    public VoiceRemote(TV tv) {
        super(tv);
    }

    @Override
    void powerOn() {
        System.out.println("Voice Remote:");
        tv.turnOn();
    }

    @Override
    void powerOff() {
        System.out.println("Voice Remote:");
        tv.turnOff();
    }

    public void speak(String command) {
        System.out.println("Executing: " + command);
    }
}

// ==========================
// Client
// ==========================
public class Main {

    public static void main(String[] args) {

        Remote remote1 =
                new BasicRemote(new SamsungTV());

        SmartRemote remote2 =
                new SmartRemote(new SonyTV());

        VoiceRemote remote3 =
                new VoiceRemote(new LGTV());

        remote1.powerOn();

        System.out.println();

        remote2.powerOn();
        remote2.voiceControl();

        System.out.println();

        remote3.powerOn();
        remote3.speak("Open YouTube");
    }
}