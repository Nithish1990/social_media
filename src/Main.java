import application.Application;
import application.utilities.helper.CustomScanner;
import application.video.Thumbnail;
import user.NonSignedVIewer;
import user.User;

import java.util.List;


public class Main {
    static Application application;
    static User user;


    public static void main(String[] args) {
        // doubt main does create app
        application = Application.installApplication();
        user = new NonSignedVIewer(application);
        open();
    }



    public static void contentCreator(){

        while (true) {
            int userInputInt = CustomScanner.scanInt("1. CreateVideo\n2.Channel Switching\n3.Upload Video");

            switch (userInputInt) {
                case 1:// creating video
                   user.makeVideo();
                    break;
                case 2:// channel switching
                    user.switchToChannel();// to be implemented
                    break;
                case 3://uploading video
                    user.uploadVideo();
                    break;
                case 4:// add admins4
                    break;
                case 5:// settings
                    break;
                case 6:// open dashBoard
                    break;
                default://exit this menu
                    return;
            }
        }
    }
    public static void viewer(){
        User viewer = user;
        while (true){
            viewer.display();
            int userInputInt = CustomScanner.scanInt("Options are \n1 select Video \n2 refresh\n3 search\n5 View Profile");
            switch (userInputInt){
                case 1:
                    viewer.selectVideoAndWatch(CustomScanner.scanInt("Enter position"));
                    break;
                case 2:// refresh
                    viewer.refresh();
                    break;
                case 3:// search
                    List<Thumbnail> videosList;// = viewer.search(CustomScanner.scanString("search...?"));
                    break;
                case 4:
                    viewer.interactToTheVideo();
                    break;
                case 5:// view profile
                    viewer.viewProfile();
                    break;
                case 6://change to content creator manually

                    break;
                default:
                    return;
            }
        }
    }
    public static void open(){
        int userInputInt;
        while (true) {
            viewer();
            userInputInt = CustomScanner.scanInt("1 Account login/signIN \n2 to Upload\n9 Exit");
            switch (userInputInt) {
                case 1:
                    userInputInt = CustomScanner.scanInt("1. SignUP\n2. LogIn");
                    switch (userInputInt){
                        case 1:
                            user = user.signUp();
                            break;
                        case 2:
                            user = user.logIn(); // if null occured then return should non signed Viewer //done
                            break;
                    }
                    break;
                case 2:
                    contentCreator();
                    break;
                case 9:
                    System.out.println("Exiting.....!!!");
                    System.exit(0);
            }
        }
    }
}