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
        for(int i = 0;i<trendingVideos.length;i+=3){
            for(int j = 0;j<3 && i<trendingVideos.length;j++){
                System.out.print((i+j+1)+" "+printingName(trendingVideos[i+j])+" ");
            }
            System.out.println();
        }
    }
    public String printingName(Thumbnail thumbnail){
        String name = "Empty";
        if(thumbnail != null){
            name = thumbnail.getVideoTitle().substring(0,5);
        }
        return name;
    }
}
