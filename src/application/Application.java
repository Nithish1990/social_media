package application;

import application.authentication.Authenticator;
import application.database.Database;
import application.utilities.SearchBar;
import application.utilities.constant.category.AgeCategory;
import application.utilities.constant.category.Category;
import application.utilities.display.Display;
import application.utilities.generator.Generator;
import application.utilities.helper.CustomScanner;
import application.video.Thumbnail;
import application.video.Video;
import application.videoplayer.VideoPlayer;
import user.User;
import user.VideoClip;
import user.Viewer;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public final String appTitle;
    private Database database;
    private Authenticator authenticator;
    private VideoPlayer videoPlayer;
    private SearchBar searchBar;
    private Display display;

    public void logOut(){}
    public List<Video> showVideos() {return null;}//-> display list of video
    public void settings(){}//-> open settings option



    //Authenticate
    public Viewer logIn(){
        return authenticator.logIn();
    }
    public Viewer signUp(){
        return authenticator.signUp();
    }
    public List<Thumbnail> search(String searchQuery){
        return searchBar.searchByName(searchQuery);
    }//-> where user can search
    public void openMenu(){}//-> open where login signOut methods will there


    public void uploadVideo(VideoClip videoClip, User user){
        if(user.getCurrentChannel()!=null) {
            try {
                String title = CustomScanner.scanString("Enter video Title: "), description = CustomScanner.scanString("Enter Video Description");
                Video video = new Video(title, user.getCurrentChannel(), description, true, AgeCategory.UA, videoClip.duration, Category.DEFAULT, new ArrayList<>());
                database.addVideo(Generator.urlGenerate(1, user.getCurrentChannel().getChannelName()), video);
                System.out.println(database.getVideoBucket());
            } catch (Exception e) {
                System.err.println("Not uploaded");
            }
            System.out.println("Uploaded");
        }else{
            System.out.println("Login first");
        }
    }
    public void display(){
        display.display(database.getTrendingVideoURL());
    }
    public Application() {
        this.appTitle = "inum mudivu pannala";
        this.database = new Database();
        this.authenticator = new Authenticator(database);
        this.videoPlayer = new VideoPlayer();
        this.searchBar = new SearchBar();
        this.display = new Display();
    }


    public String getAppTitle() {
        return appTitle;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public VideoPlayer getVideoPlayer() {
        return videoPlayer;
    }

    public void setVideoPlayer(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    public SearchBar getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(SearchBar searchBar) {
        this.searchBar = searchBar;
    }
}
