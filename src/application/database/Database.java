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


    public void addVideo(String url,Video video){// not be here should handle by app of db manager
        videoBucket.put(url,video);
        sortTrendingUrl();
    }
    public void sortTrendingUrl(){
        int i = 0;
        for(Map.Entry<String,Video>map:videoBucket.entrySet()){
            if(i>10)break;
            trendingVideo[i++] = map.getValue().getThumbnail();
        }
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
        Video video1 = new Video("TEST1",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>());
        addVideo(Generator.urlGenerate(1,channel.getChannelName()),video1);
        Video video2 = new Video("TEST2",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>()),
                video3 = new Video("TEST3",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>()),
                video4 = new Video("TEST4",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>()),
                video5 = new Video("TEST5",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>()),
                video6 = new Video("TEST6",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>());
        Video video7 = new Video("TEST7",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>());
        Video video8 = new Video("TEST8",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>());
        Video video9 = new Video("TEST9",channel,"TESTinG",true, AgeCategory.UA,10,Category.DEFAULT,new ArrayList<>());
        addVideo("2",video2);
        addVideo("3",video3);
        addVideo("4",video4);
        addVideo("5",video5);
        addVideo("6",video6);
        addVideo("7",video7);
        addVideo("8",video8);
        addVideo("9",video9);
    }
}
