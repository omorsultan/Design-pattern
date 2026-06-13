package prototype.UIbutton.Messy;

import java.util.ArrayList;
import java.util.List;

// বাটন তৈরিতে ব্যবহৃত একটি কাল্পনিক ফন্ট ক্লাস
class CustomFont {
    public String fontName;
    public int fontSize;
    
    public CustomFont(String fontName, int fontSize) {
        this.fontName = fontName;
        this.fontSize = fontSize;
    }
}

// মূল বাটন ক্লাস
class Button {
    public int width;
    public int height;
    public String color;
    public String text;
    private CustomFont font; // এটি একটি অবজেক্ট রেফারেন্স (Nested Object)

    public Button(int width, int height, String color, String text, CustomFont font) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.text = text;
        this.font = font;
    }

    public CustomFont getFont() {
        return this.font;
    }
}

// ক্লায়েন্ট কোড (এখানেই আসল ঝামেলা!)
public class Main {
    public static void main(String[] args) {
        // ১. প্রথমে একটি মাস্টার বাটন তৈরি করা হলো
        CustomFont ArialFont = new CustomFont("Arial", 14);
        Button primaryButton = new Button(150, 50, "Blue", "Submit", ArialFont);

        // ২. সমস্যা: আমাদের এই পেজে আরও ৫টি একই রকমের বাটন লাগবে, শুধু টেক্সট আলাদা হবে।
        // প্রোটোটাইপ প্যাটার্ন না থাকায় প্রতিবার ম্যানুয়ালি কপি করতে হচ্ছে:
        
        List<Button> pageButtons = new ArrayList<>();
        
        for (int i = 1; i <= 5; i++) {
            // মেসি পার্ট: ক্লায়েন্টকে প্রতিটা ফিল্ড টেনে টেনে কপি করতে হচ্ছে
            Button copyButton = new Button(
                primaryButton.width,
                primaryButton.height,
                primaryButton.color,
                "Button " + i, // শুধু টেক্সট আলাদা
                primaryButton.getFont() // এখানে লুকিয়ে আছে একটি মারাত্মক বিপদ!
            );
            pageButtons.add(copyButton);
        }

        // ৩. মারাত্মক বাগ (The Dangerous Bug):
        // আমরা যদি কোনো একটি কপি বাটনের ফন্ট সাইজ পরিবর্তন করি...
        pageButtons.get(0).getFont().fontSize = 25;

        // তাহলে আসল (Primary) বাটনের ফন্ট সাইজও বদলে যাবে! 
        System.out.println("Original Button Font Size: " + primaryButton.getFont().fontSize); 
        // আউটপুট আসবে: 25! (হওয়ার কথা ছিল 14)
    }
}