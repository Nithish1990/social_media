package user.channel;

import application.Application;
import application.utilities.constant.country.Country;
import application.utilities.helper.CustomScanner;
import user.User;
import user.VideoClip;

public class ContentCreator extends User {


    public ContentCreator(String name, String emailId, String password, String number, String dob, Application application) {
        super(name,emailId,password,number,dob,application);
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

    @Override
    public void switchToChannel() {
        setCurrentChannel(getChannelList().get(0));
    }

    @Override
    public Channel createChannel() {
        return getApplication().createChannel(this);
    }

    public void uploadVideo(){
        getApplication().uploadVideo(this);
    }

    @Override
    public void display() {
        System.out.println("C "+this.getUserName());
        getApplication().display();
    }

    @Override
    public void viewProfile() {
        System.out.println(getUserName());
        System.out.println(getUserEmailID());
        System.out.println(getCountry());
        System.out.println(getUserPhoneNumber());
        System.out.println(getSubscriptionList());
        System.out.println(getChannelList());
    }

    public void makeVideo(){

        // storing video no needed to get input but
        String title = CustomScanner.scanString("Enter Title: ");
        System.out.println("Recording");
        int userInput = CustomScanner.scanInt("Enter to stop");
        getLocalStorage().storeVideo(title,new VideoClip(title,10,10));
    }//-> user can make video

////    methods
//
//    public Channel createChannel(String name, String about, Category category){return new Channel(name,about,category,this);};
//    public Video makeVideo(){
//        String title = CustomScanner.scanString("Enter Title: ");
//        String description = CustomScanner.scanString("Enter Desc: ");
//
//        return new Video(title,currentChannel,description,true, AgeCategory.U,10,null,null);
//    }//-> user can make video
//    public void uploadVideo(Video video){
//        getApplication().uploadVideo(video);
//    }// -> user will upload video from local storage
//    public void withdraw(int amountEarned){}//-> withdraw the amount earned from the app
//
//
//    @Override
//    public void selectVideoAndWatch(int position) {
//
//    }
//    //constructor
//    public ContentCreator(String userName, String userEmailID, String password, String userPhoneNumber,
//                          String dataOfBirth, Country country, Application application) {
//
//        super(userName, userEmailID, password, userPhoneNumber, dataOfBirth,country);
//        this.amountEarned = 0;
//        this.channelList = new ArrayList<>();
//        channelList.add(createChannel(userName,userName,Category.DEFAULT));
//        switchToChannel();
//    }
}
