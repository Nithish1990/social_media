import application.Application;
import application.utilities.helper.CustomScanner;
import user.VideoClip;
import user.User;
import user.Viewer;


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
                    contentCreator.makeVideo();// TO BE CHANGE WAT CHANGE? content creator will make video and it auto maticaly stores
//                    contentCreator.getLocalStorage().storeVideo(video.getName(), video);
                    break;
                case 2:// channel switching
                    contentCreator.switchToChannel();// to be implemented
                    break;
                case 3://uploading video
                    System.out.println(contentCreator.getLocalStorage());
                    String selectedVideoName = CustomScanner.scanString("Enter Name for uploading");
                    VideoClip selectedVideo = contentCreator.getLocalStorage().getVideo(selectedVideoName);
                    contentCreator.uploadVideo(selectedVideo);
                    break;
                case 4:// add admins4
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

        while (true){
            viewer.display();
            int userInputInt = CustomScanner.scanInt("Options are \n1 select Video \n2 refresh\n3 search");
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