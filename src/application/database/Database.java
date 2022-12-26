package application.database;

import application.user.ViewerProfile;

import application.utilities.constant.category.AgeCategory;
import application.utilities.constant.category.Category;
import application.utilities.generator.Generator;
import application.video.Advertisement;
import application.video.Thumbnail;
import application.video.Video;
import user.Viewer;
import user.channel.Channel;
import user.channel.ContentCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Thumbnail[] trendingVideo;// when ppl click refresh
    private Map<String, ViewerProfile> viewerDB;
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
        injectVideo();
    }
    public static Database setUpDatabase(){
        if(database == null){
            database = new Database();
        }
        return database;
    }


    public void addVideo(String url,Video video){
        videoBucket.put(url,video);
        trendingVideo[0] = video.getThumbnail();
    }







    //getters
    public Thumbnail[] getTrendingVideoURL() {
        return trendingVideo;
    }

    public Map<String, ViewerProfile> getViewerDB() {
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




    private void injectVideo(){// for testing debugging

        ViewerProfile viewerProfile = new ViewerProfile("TEST_DEMO","Test1234@gmail.com","Test1234@gmail.com","9876543210","11/12/2001");
        Channel channel = new Channel("TEST","TESTING",Category.DEFAULT,viewerProfile);
        Video video = new Video("TESTING",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>());
        addVideo(Generator.urlGenerate(1,channel.getChannelName()),video);
        viewerDB.put("Test1234@gmail.com",viewerProfile); }
}
