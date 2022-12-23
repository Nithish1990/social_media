package user;


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
    public VideoClip getVideo(String name){
        return videos.getOrDefault(name,null);
    }
    public LocalStorage(){
        videos = new HashMap<>();
        videos.put("testv1",new VideoClip());
    }
}
