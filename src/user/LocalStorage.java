package user;

//import application.video.Video;
import user.VideoClip;
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
            System.out.println("File already exits");
        }
    }
    public VideoClip getVideo(String name){
        return videos.getOrDefault(name,null);
    }
    public LocalStorage(){
        videos = new HashMap<>();
        videos.put("1",new VideoClip());
    }
}
