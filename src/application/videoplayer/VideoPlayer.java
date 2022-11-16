package application.videoplayer;

import application.constant.quality.Quality;
import application.constant.screenorientation.ScreenOrientation;
import application.constant.speed.Speed;
import application.video.Video;

import java.sql.Time;

public class VideoPlayer {
    private int volumePercentage;
    private Quality quality; //like 4k
    private Speed speed;
    private Time currentPosition;
    private Video video;
    private ScreenOrientation screenOrientation;

    public void muteAndUnMute(){}
    public void volumeChange(int volume){}
    public void seek(int timeStamp){}
    public void fastForward(int speed){}
    public void pauseOrPlay(){}
    public void plus30Seconds(){}
    public void minus30Seconds(){}
    public void changeScreenOrientation(){}
    public void playNext(){}
    public void playPrevious(){}
    public void reportTheVideo(){}
    public void changeScreen(){}
}
