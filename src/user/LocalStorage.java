package user;


import application.video.Video;

import java.util.HashMap;
import java.util.Map;

public class LocalStorage {
    private Map<String, VideoClip> videos;
    // methods
    public void storeVideo(String name, VideoClip video){
        System.out.println("Storing");
        if(videos.getOrDefault(name,null)==null){
            videos.put(name,video);
        }else{
            System.out.println("File NAME already exits");
        }
    }
    public void display(){
        for (Map.Entry<String,VideoClip> entry : videos.entrySet())
            System.out.println("Name: " + entry.getKey());
    }
    public VideoClip getVideo(String name){
       VideoClip video = videos.getOrDefault(name,null);
       if(video == null) {
           System.out.println("No such File");
       }
       return video;
    }
    public LocalStorage(){
        videos = new HashMap<>();
        videos.put("testv1",new VideoClip());
    }



}
