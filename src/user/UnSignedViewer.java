package user;

import application.video.Video;

import java.util.List;

public class UnSignedViewer extends User{

//    methods
    public void openSettings(){}
    public void signIn(){}
    @Override
    public List<Video> search(String query) {return null;}

    @Override
    public void selectVideoAndWatch(int position) {}

    //setting method


    /*

        TO BE INCLUDE
     */




    //video player methods
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
}
