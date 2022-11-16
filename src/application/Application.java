package application;

import application.authentication.Authenticator;
import application.database.Database;
import application.utilities.SearchBar;
import application.video.Video;
import application.videoplayer.VideoPlayer;
import user.User;

import java.util.List;

public class Application {
    public final String appTitle;
    private User currentUser;
    private Database database;
    private Authenticator authenticator;
    private VideoPlayer videoPlayer;
    private SearchBar searchBar;

    public List<Video> showVideos() {return null;}//-> display list of video
    public void settings(){}//-> open settings option
    public void search(String searchQuery){}//-> where user can search
    public void openMenu(){}//-> open where login signOut methods will there

    public Application(String appTitle, User currentUser, Database database,
                       Authenticator authenticator, VideoPlayer videoPlayer, SearchBar searchBar) {
        this.appTitle = appTitle;
        this.currentUser = currentUser;
        this.database = database;
        this.authenticator = authenticator;
        this.videoPlayer = videoPlayer;
        this.searchBar = searchBar;
    }
}
