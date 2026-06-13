package prototype.UIbutton;

import java.util.ArrayList;
import java.util.List;
interface Prototype {
    Prototype clone();
}

class CustomFont {
    public String fontName;
    public int fontSize;
    
    public CustomFont(String fontName, int fontSize) {
        this.fontName = fontName;
        this.fontSize = fontSize;
    }

    // ফন্টের জন্য আলাদা কপি তৈরি করার মেথড
    public CustomFont copy() {
        return new CustomFont(this.fontName, this.fontSize);
    }
}

class Button implements Prototype {
    public int width;
    public int height;
    public String color;
    public String text;
    private CustomFont font;

    public Button(int width, int height, String color, String text, CustomFont font) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.text = text;
        this.font = font;
    }

    // প্রোটোটাইপ কনস্ট্রাক্টর (Deep Copy নিশ্চিত করে)
    public Button(Button source) {
        if (source != null) {
            this.width = source.width;
            this.height = source.height;
            this.color = source.color;
            this.text = source.text;
            // ফন্টের নতুন অবজেক্ট তৈরি করা হলো, যাতে একটির পরিবর্তনে অন্যটির ক্ষতি না হয়
            this.font = source.font.copy(); 
        }
    }
    public CustomFont getFont() {
        return this.font;
    }

    @Override
    public Prototype clone() {
        return new Button(this);
    }
}

// পরিষ্কার ক্লায়েন্ট কোড (Clean Client Code)
public class Main {
    public static void main(String[] args) {
        CustomFont ArialFont = new CustomFont("Arial", 14);
        Button primaryButton = new Button(150, 50, "Blue", "Submit", ArialFont);

        // এখন কপি করা কত সহজ এবং নিরাপদ দেখুন:
        Button clonedButton = (Button) primaryButton.clone();
        clonedButton.text = "Success";
        
        // এখন ক্লোন বাটনের ফন্ট সাইজ পরিবর্তন করলেও মূল বাটনের ফন্ট ঠিক থাকবে
        clonedButton.getFont().fontSize = 25;

        System.out.println("Original Font Size: " + primaryButton.getFont().fontSize); // আউটপুট: 14 (নিরাপদ!)
        System.out.println("Cloned Font Size: " + clonedButton.getFont().fontSize);     // আউটপুট: 25
    }
}