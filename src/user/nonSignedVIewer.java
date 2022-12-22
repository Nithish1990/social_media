package user;

import application.Application;

public class nonSignedVIewer extends User{


    public nonSignedVIewer(Application application) {
        super(application);
    }

    @Override
    public void selectVideoAndWatch(int position) {

    }

    @Override
    public void updateAccount() {

    }

    @Override
    public void interactToTheVideo() {

    }

    @Override
    public User signUp() {
        return null;
    }

    @Override
    public User logIn() {
        return null;
    }
}
