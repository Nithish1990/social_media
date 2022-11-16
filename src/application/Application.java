package application;

import application.authentication.Authenticator;
import application.utilities.Database;
import application.utilities.SearchBar;
import application.videoplayer.VideoPlayer;
import user.User;

public class Application {
    public final String appTitle;
    private User currentUser;
    private Database database;
    private Authenticator authenticator;
    private VideoPlayer videoPlayer;
    private SearchBar searchBar;


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
