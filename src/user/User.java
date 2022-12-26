package user;
import application.Application;
import application.user.ViewerProfile;
import application.utilities.constant.category.Category;
import application.utilities.constant.country.Country;
import application.utilities.helper.CustomScanner;
import application.video.Thumbnail;
import application.video.Video;
import user.channel.Channel;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class User {


    //normal user details
    private String userName;
    private String userEmailID;
    private String password;
    private String userPhoneNumber;
    private String dataOfBirth;//will be changed to date
    private boolean eighteenPlus;// naming is not convenient to be change
    private Country country;
//    private boolean primeUser;//doubt
//    private boolean isBannedUser;// doubt // if user is banned cant post cmt
    private ArrayList<Channel> subscriptionList;
    private ArrayList<Thumbnail> watchLaterVideo;
    private Stack<Thumbnail> notification;

    private Stack<Thumbnail> watchHistory;
    private Stack<Video> previousVideo;// stored in local storage
    //content creator
//    private long amountEarned;
    private List<Channel>channelList;
    private Channel currentChannel;

    //objets
    private Application application;
    private LocalStorage localStorage;


    // methods
//    public List<Thumbnail> search(String query) {
//        return getApplication().search(query);
//    }
    public abstract void selectVideoAndWatch(int position);
    public abstract void updateAccount();//-> user can change username and change to prime etc
    public abstract void interactToTheVideo();//-> like share subscribe comments
    public void refresh(){}
    public abstract User signUp();
    public abstract User logIn();
    public abstract void switchToChannel();
    public abstract  Channel createChannel();
    public abstract void makeVideo();//                                                                                                                                         String title = CustomScanner.scanString("Enter Title: ");//        System.out.println("Recording");//        int userInput = CustomScanner.scanInt("Enter to stop");//        localStorage.storeVideo(title,new VideoClip(title,10,10));
//    }//-> user can make video
    public  abstract void uploadVideo();//                                                                                                                                  System.out.println(this.getLocalStorage());//        String selectedVideoName = CustomScanner.scanString("Enter Name for uploading");//        VideoClip selectedVideo = this.getLocalStorage().getVideo(selectedVideoName);//        getApplication().uploadVideo(selectedVideo,this);
//    }// -> user will upload video from local storage
    public abstract void display();
    public abstract void viewProfile();
    public void withdraw(int amountEarned){}
    // mediaPlayer methods
    public void volumeChange(int volume){}
    public void mute(){}
    public void seek(int timeStamp){}
    public void fastForward(int speed){}
    public void pauseOrPlay(){}
    public void plus30Seconds(){}
    public void minus30Seconds(){}
    public void changeScreenOrientation(){}
    public void playNext(){}
    public void playPrevious(){}
    public void reportTheVideo(){}
    public void changeScreen(){}// full screen



  //constructor

    public User(String userName, String userEmailID, String password, String userPhoneNumber, String dataOfBirth,Application application) {

        this.userName = userName;
        this.userEmailID = userEmailID;
        this.password = password;
        this.userPhoneNumber = userPhoneNumber;
        this.dataOfBirth = dataOfBirth;
        this.eighteenPlus = false;
        this.country = Country.INDIA;
        this.subscriptionList = new ArrayList<>();
        this.watchLaterVideo = new ArrayList<>();
        this.notification = new Stack<>();
        this.watchHistory = new Stack<>();
        this.previousVideo = new Stack<>();
        this.channelList = new ArrayList<>();
        this.application = application;
        this.localStorage = new LocalStorage();
    }

    public User(Application application){// for those didnt signed but can use

        this.application = application;
        this.watchHistory = new Stack<>();
        this.previousVideo = new Stack<>();
        this.localStorage = new LocalStorage();
    }

    //getter setter


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmailID() {
        return userEmailID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getDataOfBirth() {
        return dataOfBirth;
    }

    public boolean isEighteenPlus() {
        return eighteenPlus;
    }

    public void setEighteenPlus(boolean eighteenPlus) {
        this.eighteenPlus = eighteenPlus;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public ArrayList<Channel> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(ArrayList<Channel> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    public ArrayList<Thumbnail> getWatchLaterVideo() {
        return watchLaterVideo;
    }

    public void setWatchLaterVideo(ArrayList<Thumbnail> watchLaterVideo) {
        this.watchLaterVideo = watchLaterVideo;
    }

    public Stack<Thumbnail> getNotification() {
        return notification;
    }

    public void setNotification(Stack<Thumbnail> notification) {
        this.notification = notification;
    }

    public Stack<Thumbnail> getWatchHistory() {
        return watchHistory;
    }

    public void setWatchHistory(Stack<Thumbnail> watchHistory) {
        this.watchHistory = watchHistory;
    }

    public Stack<Video> getPreviousVideo() {
        return previousVideo;
    }

    public void setPreviousVideo(Stack<Video> previousVideo) {
        this.previousVideo = previousVideo;
    }


    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public Channel getCurrentChannel() {
        if(currentChannel == null){
//            currentChannel = createChannel(this.userName,"Default",Category.DEFAULT);
            currentChannel = createChannel();
        }
        return currentChannel;
    }

    public void setCurrentChannel(Channel currentChannel) {
        this.currentChannel = currentChannel;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public LocalStorage getLocalStorage() {
        return localStorage;
    }


    public void setLocalStorage(LocalStorage localStorage) {
        this.localStorage = localStorage;
    }
}