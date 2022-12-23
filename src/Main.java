import application.Application;
import application.utilities.helper.CustomScanner;
import user.VideoClip;
import user.User;
import user.Viewer;
import user.channel.ContentCreator;


public class Main {
    static Application application;
    static User user;
    public static void main(String[] args) {
        // doubt main does create app
        application = Application.installApplication();
        user = new Viewer(application);

        account();
//        contentCreator(user);
    }
    public static void contentCreator(User contentCreator){
        while (true) {
            int userInputInt = CustomScanner.scanInt("1. CreateVideo\n2.Channel Switching\n3.Upload Video");

            switch (userInputInt) {
                case 1:// creating video
                    VideoClip video = contentCreator.makeVideo();
                    contentCreator.getLocalStorage().storeVideo(video.getName(), video);
                    break;
                case 2:// channel switching
                    contentCreator.switchToChannel();// to be implemented
                    break;
                case 3://uploading video
                    VideoClip selectedVideo = contentCreator.getLocalStorage().getVideo("1");
                    contentCreator.uploadVideo(selectedVideo);
                    break;
                case 4:// add admins
                    break;
                case 5:// settings
                    break;
                case 6:// open dashBoard
                    break;
                case 9://logout
                    return;
            }
        }
    }
    public static void viewer(Viewer viewer){
        System.out.println(viewer.getUserEmailID()==null?"Name less Creature":"Current user is :"+viewer.getUserName());
        while (true){
            viewer.getApplication().display();
            int userInputInt = CustomScanner.scanInt("1 select Video \n2 refresh\n3 search");
            switch (userInputInt){
                case 1:
                    viewer.selectVideoAndWatch(0);
                    break;
                case 2:// refresh
                    viewer.refresh();
                    break;
                case 3:// search
//                    List <Thumbnail> videosList = viewer.search(CustomScanner.scanString("search...?"));

                    break;
                case 4://interaction
                    

                    break;
                default:
                    return;
            }
        }
    }
    public static void account(){
        int userInputInt;
        while (true) {
            viewer((Viewer)user);
            userInputInt = CustomScanner.scanInt("1 account login/signIN \n2 to Upload\n9 Exit");
            switch (userInputInt) {
                case 1:
                    userInputInt = CustomScanner.scanInt("1. SignUP\n2. LogIn");
                    switch (userInputInt){
                        case 1:
                            user = user.signUp();
                            break;
                        case 2:
                            user = user.logIn();
                            // validate null pointer exp becoz user if not foung null occuring
                            break;
                    }
                    break;
                case 2:
                    contentCreator(user);
                    break;
                case 9:
                    System.out.println("Exit");
                    return;
            }
        }
    }
}