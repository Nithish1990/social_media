package application;

import application.authentication.Authenticator;
import application.authentication.SignUP;
import application.database.Database;
import application.user.ViewerProfile;
import application.utilities.SearchBar;
import application.utilities.constant.category.AgeCategory;
import application.utilities.constant.category.Category;
import application.utilities.display.Display;
import application.utilities.generator.Generator;
import application.utilities.helper.CustomScanner;
import application.video.Thumbnail;
import application.video.Video;
import application.videoplayer.VideoPlayer;
import user.NonSignedVIewer;
import user.User;
import user.VideoClip;
import user.Viewer;
import user.channel.Channel;

import javax.jws.soap.SOAPBinding;
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
    public User logIn(){
        String emailId = CustomScanner.scanString("Enter emailId"),password = CustomScanner.scanString("Enter password");

        User user  = authenticator.logIn(emailId,password,database.getViewerDB());
        if(user == null)user = new NonSignedVIewer(this);
        return user;
    }
    public User signUp(){
        ViewerProfile viewerProfile = SignUP.signUP();
        User user = authenticator.signUp(viewerProfile,database.getViewerDB());
        if(user == null)user = new NonSignedVIewer(this);
        return user;
    }
    public List<Thumbnail> search(String searchQuery){
        return searchBar.searchByName(searchQuery);
    }//-> where user can search
    public void openMenu(){}//-> open where login signOut methods will there

    /*
    Sigleton
     */
    private static Application application;
    public void uploadVideo(User user){
        System.out.println(user.getLocalStorage());
        String selectedVideoName = CustomScanner.scanString("Enter Name for uploading");
        VideoClip videoClip = user.getLocalStorage().getVideo(selectedVideoName);
        if(user.getCurrentChannel()!=null) {
            try {
                String title = CustomScanner.scanString("Enter video Title: "), description = CustomScanner.scanString("Enter Video Description");
                Video video = new Video(title, user.getCurrentChannel(), description, true, AgeCategory.UA, videoClip.duration, Category.DEFAULT, new ArrayList<>());
                database.addVideo(Generator.urlGenerate(1, user.getCurrentChannel().getChannelName()), video);
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
    public void playVideo(int position){
        videoPlayer.playVideo(getDatabase().getVideoBucket().get(getDatabase().getTrendingVideoURL()[position].getUrl()));
    }
    private Application() {
        this.appTitle = "inum mudivu pannala";
        this.database = Database.setUpDatabase();
        this.authenticator = new Authenticator(this);
        this.videoPlayer = new VideoPlayer();
        this.searchBar = new SearchBar();
        this.display = new Display();
    }
    public static Application installApplication(){
        if(application == null){
            application = new Application();
        }
        return application;
    }
    public Channel createChannel(User user){
        String name = CustomScanner.scanString("Enter the name for the channel"),about = CustomScanner.scanString("Enter about");
        return new Channel(name,about,Category.DEFAULT,database.getViewerDB().get(user.getUserEmailID()));
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
