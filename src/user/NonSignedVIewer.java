package user;

import application.Application;
import user.channel.Channel;

public class NonSignedVIewer extends User{


    public NonSignedVIewer(Application application) {
        super(application);
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
        System.out.println("Login first");
    }

    @Override
    public User signUp() {
        return getApplication().signUp();
    }

    @Override
    public User logIn() {
        return getApplication().logIn();
    }

    @Override
    public void switchToChannel() {
        System.out.println("Login first");
    }

    @Override
    public Channel createChannel() {
        System.out.println("Login first");
        return null;
    }

    @Override
    public void makeVideo() {
        System.out.println("Login first");
    }

    @Override
    public void uploadVideo() {
        System.out.println("Login first");

    }
    public void display(){
        System.out.println("Name less creature");
        getApplication().display();
    }

    @Override
    public void viewProfile() {
        System.out.println("login first");
    }
}
