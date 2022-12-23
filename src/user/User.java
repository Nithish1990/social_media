package user;
import application.Application;
import application.utilities.constant.category.AgeCategory;
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
    private boolean primeUser;//doubt
    private boolean isBannedUser;// doubt // if user is banned cant post cmt
    private ArrayList<Channel> subscriptionList;
    private ArrayList<Thumbnail> watchLaterVideo;
    private Stack<Thumbnail> notification;

    private Stack<Thumbnail> watchHistory;
    private Stack<Video> previousVideo;
    //content creator
    private long amountEarned;
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
    public void switchToChannel(){
        currentChannel = channelList.get(0);
    }
    public Channel createChannel(String name, String about, Category category){
        return new Channel(name,about,category,this);
    }
    public VideoClip makeVideo(){
        String title = CustomScanner.scanString("Enter Title: ");
        String description = CustomScanner.scanString("Enter Desc: ");
        return new VideoClip(title,10,10);
//        return new Video(title,currentChannel,description,true, AgeCategory.U,10,null,null);
    }//-> user can make video
    public void uploadVideo(VideoClip video){
        getApplication().uploadVideo(video,this);
        this.getCurrentChannel();
    }// -> user will upload video from local storage
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
        this.primeUser = false;
        this.isBannedUser = false;
        this.subscriptionList = new ArrayList<>();
        this.watchLaterVideo = new ArrayList<>();
        this.notification = new Stack<>();
        this.watchHistory = new Stack<>();
        this.previousVideo = new Stack<>();
        this.amountEarned = 0;
        this.channelList = new ArrayList<>();
        this.application = application;
        this.localStorage = new LocalStorage();
    }

    public User(Application application){

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

    public boolean isPrimeUser() {
        return primeUser;
    }

    public void setPrimeUser(boolean primeUser) {
        this.primeUser = primeUser;
    }

    public boolean isBannedUser() {
        return isBannedUser;
    }

    public void setBannedUser(boolean bannedUser) {
        isBannedUser = bannedUser;
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

    public long getAmountEarned() {
        return amountEarned;
    }

    public void setAmountEarned(long amountEarned) {
        this.amountEarned = amountEarned;
    }

    public List<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public Channel getCurrentChannel() {
        if(currentChannel == null){
            currentChannel = createChannel(this.userName,"Default",Category.DEFAULT);
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