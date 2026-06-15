// ১. State Interface - সব স্টেটের জন্য কমন মেথড

package State;
interface State {
    void clickPlay(AudioPlayer context);
    void clickLock(AudioPlayer context);
}

// ২. Concrete States - প্রতিটি স্টেটের জন্য আলাদা ক্লাস

// Ready State
class ReadyState implements State {
    @Override
    public void clickPlay(AudioPlayer context) {
        System.out.println("Starting playback...");
        context.setState(new PlayingState()); // স্টেট পরিবর্তন
    }

    @Override
    public void clickLock(AudioPlayer context) {
        System.out.println("Locking the player.");
        context.setState(new LockedState());
    }
}

// Playing State
class PlayingState implements State {
    @Override
    public void clickPlay(AudioPlayer context) {
        System.out.println("Pausing playback...");
        context.setState(new PausedState());
    }

    @Override
    public void clickLock(AudioPlayer context) {
        System.out.println("Locking the player while playing.");
        context.setState(new LockedState());
    }
}

// Paused State
class PausedState implements State {
    @Override
    public void clickPlay(AudioPlayer context) {
        System.out.println("Resuming playback...");
        context.setState(new PlayingState());
    }

    @Override
    public void clickLock(AudioPlayer context) {
        System.out.println("Locking the player from paused state.");
        context.setState(new LockedState());
    }
}

// Locked State
class LockedState implements State {
    @Override
    public void clickPlay(AudioPlayer context) {
        System.out.println("Player is locked! Do nothing.");
    }

    @Override
    public void clickLock(AudioPlayer context) {
        System.out.println("Unlocking the player. Back to Ready.");
        context.setState(new ReadyState());
    }
}

// ৩. Context Class - যা বাইরের ক্লায়েন্ট ব্যবহার করবে
class AudioPlayer {
    private State state;

    public AudioPlayer() {
        // শুরুতে প্লেয়ার Ready স্টেটে থাকবে
        this.state = new ReadyState();
    }

    // রানটাইমে স্টেট পরিবর্তন করার মেথড
    public void setState(State state) {
        this.state = state;
    }

    // ক্লায়েন্টের অ্যাকশনগুলো বর্তমান স্টেটের অবজেক্টের কাছে ডেলিগেট (হস্তান্তর) করা হচ্ছে
    public void clickPlay() {
        state.clickPlay(this);
    }

    public void clickLock() {
        state.clickLock(this);
    }
}

// ৪. ক্লায়েন্ট কোড (Execution)
public class MainStatePattern {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        // ReadyState -> clickPlay() -> PlayingState হবে
        player.clickPlay(); 
        
        // PlayingState -> clickPlay() -> PausedState হবে
        player.clickPlay(); 
        
        // PausedState -> clickLock() -> LockedState হবে
        player.clickLock(); 
        
        // LockedState -> clickPlay() -> লকড তাই কিছু হবে না
        player.clickPlay(); 
        
        // LockedState -> clickLock() -> Unlocked হয়ে ReadyState হবে
        player.clickLock(); 
    }
}