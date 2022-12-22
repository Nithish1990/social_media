package application.utilities.display;

import application.video.Thumbnail;

import java.util.List;

public class Display {
    public void display(List<Thumbnail> thumbnails){
        for(Thumbnail thumbnail:thumbnails){
            System.out.println(thumbnail);
        }
    }
    public void display(Thumbnail[] trendingVideos){
        for(int i = 0;i<trendingVideos.length;i++){
            System.out.println(i+" "+trendingVideos[i]);
        }
    }
}
