package proxy;

import java.beans.PropertyChangeListenerProxy;
import java.util.HashMap;
import java.util.Map;

 interface YouTubeService{
  String downloadVideo(String videoId);
}

class RealYouTubeService implements YouTubeService{
  
  public String downloadVideo(String videoId){
    System.out.println("Connecting to Youtuve server for vide ID: "+ videoId);
    simulateNetworkLatency();
    return "Vide Data of " + videoId;
  }

  private void simulateNetworkLatency(){
    try{
      Thread.sleep(2000);
    } catch (InterruptedException e){
      e.printStackTrace();
    }
  }
}

class proxyYouTubeService implements YouTubeService {

  private final YouTubeService realService;
  private final Map<String, String> videoCache;

  public proxyYouTubeService(){
    this.realService = new RealYouTubeService();
    this.videoCache = new HashMap<>();
  }

  public String downloadVideo(String videoId){
    if(videoCache.containsKey(videoId)){
      System.out.println("Retrieved from CACHE for video ID: " + videoId);
      return videoCache.get(videoId);
    }

    String videoData = realService.downloadVideo(videoId);
    videoCache.put(videoId, videoData);
    return videoData;
  }
}


public class Main {
  public static void main(String[] args) {
    YouTubeService service = new proxyYouTubeService();

    System.out.println("--- First Request (Java Tutorial) ---");
        long startTime = System.currentTimeMillis();
        System.out.println(service.downloadVideo("java-101"));
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms\n");

    System.out.println("--- Second Request (Same Video) ---");
        startTime = System.currentTimeMillis();
        // এবার এটি সরাসরি ক্যাশ থেকে আসবে, কোনো নেটওয়ার্ক লেটেন্সি থাকবে না
        System.out.println(service.downloadVideo("java-101"));
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms\n");

  }
}
