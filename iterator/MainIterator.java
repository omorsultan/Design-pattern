// package iterator;
// import java.util.ArrayList;
// import java.util.List;

// interface Iterator{
//     boolean hasNext();
//     Object next();
// }

// interface Collection{
//     Iterator createIterator();

// }

// class FacebookIterator implements Iterator{
//     private List<String> channels;
//     private int pos = 0;

//     public FacebookIterator(List<String> channels){
//         this.channels = channels;
//     }

//     public boolean hasNext(){
//         return pos < channels.size() && (channels.get(pos+1)!=null);
//     }
//     public Object next(){
//         return channels.get(pos++);
//     }
// }

// class LinkedInIterator implements Iterator {
//     private String[] groups;
//     private int pos = 0;

    
// }
// // ১. ফেসবুকের কালেকশন ক্লাস (যা ArrayList ব্যবহার করে)
// class FacebookCollection implements Collection {
//     private List<String> channels;

//     public FacebookCollectionMessy() {
//         channels = new ArrayList<>();
//         channels.add("Facebook Tech Community");
//         channels.add("Facebook Dev Group");
//     }

//     // ইন্টারনাল স্ট্রাকচার (List) সরাসরি এক্সপোজ করা হলো
//     public List<String> getChannels() {
//         return channels;
//     }
// }

// // ২. লিঙ্কডইনের কালেকশন ক্লাস (যা ফিক্সড String Array ব্যবহার করে)
// class LinkedInCollection implements Collection {
//     private String[] groups;
//     private int index = 0;

//     public LinkedInCollectionMessy() {
//         groups = new String[2];
//         addGroup("LinkedIn Java Professionals");
//         addGroup("LinkedIn Job Network");
//     }

//     public void addGroup(String groupName) {
//         if (index < groups.length) {
//             groups[index] = groupName;
//             index++;
//         }
//     }

//     // ইন্টারনাল স্ট্রাকচার (Array) সরাসরি এক্সপোজ করা হলো
//     public String[] getGroups() {
//         return groups;
//     }
// }

// // ৩. Execution (Main Class - Client)
// public class MainIterator {
//     public static void main(String[] args) {
//         FacebookCollectionMessy fb = new FacebookCollectionMessy();
//         LinkedInCollectionMessy li = new LinkedInCollectionMessy();

//         System.out.println("--- Printing Social Media Groups ---\n");

//         // সমস্যা ১: ফেসবুকের ডাটা প্রিন্ট করতে ক্লায়েন্টকে ArrayList-এর সাইজ এবং get() মেথড জানতে হচ্ছে
//         List<String> fbChannels = fb.getChannels();
//         System.out.println("Facebook Channels:");
//         for (int i = 0; i < fbChannels.size(); i++) {
//             System.out.println("- " + fbChannels.get(i));
//         }

//         System.out.println();

//         // সমস্যা ২: লিঙ্কডইনের ডাটা প্রিন্ট করতে ক্লায়েন্টকে সম্পূর্ণ ভিন্ন নিয়মে (অ্যারের .length দিয়ে) লুপ চালাতে হচ্ছে
//         String[] liGroups = li.getGroups();
//         System.out.println("LinkedIn Groups:");
//         for (int i = 0; i < liGroups.length; i++) {
//             System.out.println("- " + liGroups[i]);
//         }
//     }
// }