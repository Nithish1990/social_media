package user;
import application.Application;
import application.video.Thumbnail;
import application.video.Video;

import java.util.List;
import java.util.Stack;

public abstract class User {
    private Application application;
    private Stack<Thumbnail> watchHistory;
    private Stack<Video> previousVideo;


    public abstract List<Video> search(String query);
    public abstract void selectVideoAndWatch(int position);

    // mediaPlayer methods
    public abstract void volumeChange(int volume);
    public abstract void mute();
    public abstract void seek(int timeStamp);
    public abstract void fastForward(int speed);
    public abstract void pauseOrPlay();
    public abstract void plus30Seconds();
    public abstract void minus30Seconds();
    public abstract void changeScreenOrientation();
    public abstract void playNext();
    public abstract void playPrevious();
    public abstract void reportTheVideo();
    public abstract void changeScreen();// full screen
}