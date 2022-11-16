package user;

import application.utilities.constant.country.Country;
import application.video.Video;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContentCreator extends Viewer{


    private long amountEarned;
    private List<Channel>channelList;
//    methods
    public Channel createChannel(){return null;};
    public Video makeVideo(){return null;}//-> user can make video
    public void uploadVideo(){}// -> user will upload video from local storage
    public void withdraw(int amountEarned){}//-> withdraw the amount earned from the app

    @Override
    public List<Video> search(String query) {
        return null;
    }

    @Override
    public void selectVideoAndWatch(int position) {

    }

    @Override
    public void volumeChange(int volume) {

    }

    @Override
    public void mute() {

    }

    @Override
    public void seek(int timeStamp) {

    }

    @Override
    public void fastForward(int speed) {

    }

    @Override
    public void pauseOrPlay() {

    }

    @Override
    public void plus30Seconds() {

    }

    @Override
    public void minus30Seconds() {

    }

    @Override
    public void changeScreenOrientation() {

    }

    @Override
    public void playNext() {

    }

    @Override
    public void playPrevious() {

    }

    @Override
    public void reportTheVideo() {

    }

    @Override
    public void changeScreen() {

    }

    //constructor
    public ContentCreator(String userName, String userEmailID, String password, String userPhoneNumber,
                          Date dataOfBirth, byte userAge, Country country) {

        super(userName, userEmailID, password, userPhoneNumber, dataOfBirth, userAge, country);
        this.amountEarned = 0;
        this.channelList = new ArrayList<>();
    }
}
