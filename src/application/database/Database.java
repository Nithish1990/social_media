package application.database;

import application.utilities.constant.category.AgeCategory;
import application.utilities.constant.category.Category;
import application.utilities.generator.Generator;
import application.video.Advertisement;
import application.video.Thumbnail;
import application.video.Video;
import user.channel.ContentCreator;
import user.Viewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Thumbnail[] trendingVideoURL;// when ppl click refresh
    private Map<String, Viewer> viewerDB;
    private Map<String, ContentCreator> contentCreatorBucket;
    private Map<String, Video> videoBucket;
    private List<Advertisement> ads;

    public Database(){
        trendingVideoURL = new Thumbnail[10];
        viewerDB = new HashMap<>();
        contentCreatorBucket = new HashMap<>();
        videoBucket= new HashMap<>();
        ads = new ArrayList<>();
    }


    public void addVideo(String url,Video video){
        videoBucket.put(url,video);
    }
    public void addUser(Viewer viewer){
        viewerDB.put(viewer.getUserEmailID(),viewer);
    }
    public Viewer getUser(String emailId){
        return viewerDB.getOrDefault(emailId,null);
    }






    //getters
    public Thumbnail[] getTrendingVideoURL() {
        return trendingVideoURL;
    }

    public Map<String, Viewer> getViewerDB() {
        return viewerDB;
    }

    public Map<String, ContentCreator> getContentCreator() {
        return contentCreatorBucket;
    }

    public Map<String, Video> getVideoBucket() {
        return videoBucket;
    }

    public List<Advertisement> getAds() {
        return ads;
    }




    private void injectVideo(){
        Video video1 = new Video("test1",null,"testing",true, AgeCategory.UA,10, Category.NEWS,null),
                video2 = new Video("test2",null,"testing",true, AgeCategory.UA,10, Category.NEWS,null);
        videoBucket.put(Generator.urlGenerate(1,"Utube"),video1);
        videoBucket.put("url1",video2);
    }
}
