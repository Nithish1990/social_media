package application.database;

import application.utilities.constant.category.AgeCategory;
import application.utilities.constant.category.Category;
import application.utilities.constant.country.Country;
import application.utilities.generator.Generator;
import application.video.Advertisement;
import application.video.Thumbnail;
import application.video.Video;
import user.User;
import user.channel.Channel;
import user.channel.ContentCreator;
import user.Viewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Thumbnail[] trendingVideo;// when ppl click refresh
    private Map<String, Viewer> viewerDB;
    private Map<String, ContentCreator> contentCreatorBucket;
    private Map<String, Video> videoBucket;
    private List<Advertisement> ads;


    //singleton obj
    private static Database database;
    private Database(){
        trendingVideo = new Thumbnail[9];
        viewerDB = new HashMap<>();
        contentCreatorBucket = new HashMap<>();
        videoBucket= new HashMap<>();
        ads = new ArrayList<>();
//        injectVideo();
    }
    public static Database installDatabase(){
        if(database == null){
            database = new Database();
        }
        return database;
    }


    public void addVideo(String url,Video video){
        videoBucket.put(url,video);
        System.out.println(videoBucket);
        trendingVideo[0] = video.getThumbnail();
    }
    public void addUser(Viewer viewer){
        viewerDB.put(viewer.getUserEmailID(),viewer);
    }
    public Viewer getUser(String emailId){
        return viewerDB.getOrDefault(emailId,null);
    }






    //getters
    public Thumbnail[] getTrendingVideoURL() {
        return trendingVideo;
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
//        Channel channel = new Channel("Testing", "Test", Category.DEFAULT,new ContentCreator("Test", "Test1234@gmail.com",
//                "Test1234@gmail.com", "9876543210", "11/12/01"));
//        Video video1 = new Video("test1",channel,"testing",true, AgeCategory.UA,10, Category.NEWS,null),
//                video2 = new Video("test2",channel,"testing",true, AgeCategory.UA,10, Category.NEWS,null);
//        videoBucket.put(Generator.urlGenerate(1,"Utube"),video1);
//        videoBucket.put("url1",video2);
//        trendingVideo[0] = video1.getThumbnail();
//        trendingVideo[1] = video2.getThumbnail();
    }
}
