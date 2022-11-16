package user;

import application.utilities.constant.country.Country;
import application.video.Thumbnail;
import application.video.Video;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class Viewer extends User{

    //attribute
    private String userName;
    private final String userEmailID;
    private String password;
    private String userPhoneNumber;
    private Date dataOfBirth;
    private byte userAge;
    private Country country;
    private boolean primeUser;//doubt
    private boolean isBannedUser;// doubt // if user is banned cant post cmt
    private ArrayList<Channel> subscriptionList;
    private ArrayList<Thumbnail> watchLaterVideo;
    private Stack<Thumbnail> notification;


    //methods
    public void updateAccount() {}//-> user can change username and change to prime etc
    public void interactToTheVideo(){}//-> like share subscribe comments
    public void switchToChannel(){}//-> if he wants to change to channel
    public void deleteAccount(){}//-> deleting from the database
    public void refresh(){}

    @Override
    public List<Video> search(String query) {
        return null;
    }

    @Override
    public void selectVideoAndWatch(int position) {}

    //methods of video Player
    @Override
    public void volumeChange(int volume) {}

    @Override
    public void mute() {}

    @Override
    public void seek(int timeStamp) {}

    @Override
    public void fastForward(int speed) {}

    @Override
    public void pauseOrPlay() {}

    @Override
    public void plus30Seconds() {}

    @Override
    public void minus30Seconds() {}

    @Override
    public void changeScreenOrientation() {}

    @Override
    public void playNext() {}

    @Override
    public void playPrevious() {}

    @Override
    public void reportTheVideo() {}

    @Override
    public void changeScreen() {}

    //constructor and getter setters
    public Viewer(String userName, String userEmailID, String password, String userPhoneNumber,
                  Date dataOfBirth, byte userAge, Country country) {

        this.userName = userName;
        this.userEmailID = userEmailID;
        this.password = password;
        this.userPhoneNumber = userPhoneNumber;
        this.dataOfBirth = dataOfBirth;
        this.userAge = userAge;
        this.country = country;
        this.primeUser = false;
        this.isBannedUser = false;
        this.subscriptionList = new ArrayList<>();
        this.watchLaterVideo = new ArrayList<>();
        this.notification = new Stack<>();
    }


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

    public Date getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(Date dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public byte getUserAge() {
        return userAge;
    }

    public void setUserAge(byte userAge) {
        this.userAge = userAge;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public boolean isBannedUser() {
        return isBannedUser;
    }

    public boolean isPrimeUser() {
        return primeUser;
    }

    public ArrayList<Channel> getSubscriptionList() {
        return subscriptionList;
    }

    public ArrayList<Thumbnail> getWatchLaterVideo() {
        return watchLaterVideo;
    }

    public Stack<Thumbnail> getNotification() {
        return notification;
    }
}
