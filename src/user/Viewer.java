package user;

import application.Application;
import application.user.ViewerProfile;
import application.utilities.helper.CustomScanner;
import user.channel.Channel;

public class Viewer extends User{
    @Override
    public User signUp() {
        return getApplication().signUp();
    }
    @Override
    public User logIn(){
        return getApplication().logIn();
    }

    @Override
    public void switchToChannel() {
        setCurrentChannel(getChannelList().get(0));
    }

    @Override
    public Channel createChannel() {
        return getApplication().createChannel(this);
    }

    @Override
    public void makeVideo() {
        String title = CustomScanner.scanString("Enter Title: ");
        System.out.println("Recording");
        int userInput = CustomScanner.scanInt("Enter to stop");
        getLocalStorage().storeVideo(title,new VideoClip(title,10,10));
    }

    @Override
    public void uploadVideo() {
        getApplication().uploadVideo(this);
    }

    @Override
    public void display() {
        System.out.println(" "+this.getUserName());
        getApplication().display();
    }

    @Override
    public void viewProfile() {
        System.out.println(getUserName());
        System.out.println(getUserEmailID());
        System.out.println(getCountry());
        System.out.println(getSubscriptionList());
        System.out.println(getUserPhoneNumber());
    }

    public Viewer(Application application) {
        super(application);
    }
    public Viewer(ViewerProfile viewerProfile){
        super(viewerProfile.getUserName(),viewerProfile.getUserEmailID(),viewerProfile.getPassword(),viewerProfile.getUserPhoneNumber(), viewerProfile.getDataOfBirth(),Application.installApplication());
    }

    @Override
    public void selectVideoAndWatch(int position) {
        getApplication().playVideo(position);
    }

    @Override
    public void updateAccount() {

    }

    @Override
    public void interactToTheVideo() {
        getApplication().getVideoPlayer().getCurrentVideo().channel.getSubscribersCount();
    }


    //attribute
//    private String userName;
//    private final String userEmailID;
//    private String password;
//    private String userPhoneNumber;
//    private String dataOfBirth;//will be changed to date
//    private boolean eighteenPlus;// naming is not convenient to be change
//    private Country country;
//    private boolean primeUser;//doubt
//    private boolean isBannedUser;// doubt // if user is banned cant post cmt
//    private ArrayList<Channel> subscriptionList;
//    private ArrayList<Thumbnail> watchLaterVideo;
//    private Stack<Thumbnail> notification;
//
//
//    //methods
//    public void updateAccount() {}//-> user can change username and change to prime etc
//    public void interactToTheVideo(){}//-> like share subscribe comments
//    public void deleteAccount(){}//-> deleting from the database
//    public void refresh(){}
//
//
//    @Override
//    public void selectVideoAndWatch(int position) {}
//
//
//
//    //constructor and getter setters
//    public Viewer(String userName, String userEmailID, String password, String userPhoneNumber,
//                  String dataOfBirth, Country country, Application application) {
//        super(application);
//        this.userName = userName;
//        this.userEmailID = userEmailID;
//        this.password = password;
//        this.userPhoneNumber = userPhoneNumber;
//        this.dataOfBirth = dataOfBirth;
//        this.eighteenPlus = DataCalculator.is18Plus();
//        this.country = country;
//        this.primeUser = false;
//        this.isBannedUser = false;
//        this.subscriptionList = new ArrayList<>();
//        this.watchLaterVideo = new ArrayList<>();
//        this.notification = new Stack<>();
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getUserEmailID() {
//        return userEmailID;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUserPhoneNumber() {
//        return userPhoneNumber;
//    }
//
//    public void setUserPhoneNumber(String userPhoneNumber) {
//        this.userPhoneNumber = userPhoneNumber;
//    }
//
//    public String getDataOfBirth() {
//        return dataOfBirth;
//    }
//
//    public void setDataOfBirth(String dataOfBirth) {
//        this.dataOfBirth = dataOfBirth;
//    }
//
//    public boolean isEighteenPlus() {
//        return eighteenPlus;
//    }
//
//    public void setEighteenPlus(boolean eighteenPlus) {
//        this.eighteenPlus = eighteenPlus;
//    }
//
//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }
//
//
//    public boolean isBannedUser() {
//        return isBannedUser;
//    }
//
//    public boolean isPrimeUser() {
//        return primeUser;
//    }
//
//    public ArrayList<Channel> getSubscriptionList() {
//        return subscriptionList;
//    }
//
//    public ArrayList<Thumbnail> getWatchLaterVideo() {
//        return watchLaterVideo;
//    }
//
//    public Stack<Thumbnail> getNotification() {
//        return notification;
//    }
}
