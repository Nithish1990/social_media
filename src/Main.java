import application.Application;
import application.utilities.helper.CustomScanner;
import user.VideoClip;
import user.User;
import user.Viewer;


public class Main {
    static Application application;
    public static void main(String[] args) {
        // doubt main does create app
        application = new Application();
        User user = new Viewer(application);

        int userInputInt;
        while (true) {
            userInputInt = CustomScanner.scanInt("1 account login/signIN \n3 Exit");
            switch (userInputInt) {
                case 1:
                    userInputInt = CustomScanner.scanInt("1. SignUP\n2. LogIn");
                    switch (userInputInt){
                        case 1:
                            user.signUp();
                            break;
                        case 2:
                            user.logIn();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Exit");
                    return;
                case 3:
                    viewer((Viewer)user);
                    break;
            }
        }
    }
    public static void contentCreator(User contentCreator){
        while (true) {
            int userInputInt = CustomScanner.scanInt();
//            switch (userInputInt) {
//                case 1:// creating video
//                    VideoClip ideo = contentCreator.makeVideo();
//                    contentCreator.getLocalStorage().storeVideo(video.getVideoTitle(), video);
//                    break;
//                case 2:// channel switching
//                    contentCreator.switchToChannel();// to be implemented
//                    break;
//                case 3://uploading video
//                    Video selectedVideo = contentCreator.getLocalStorage().getVideo("1 ");
//                    contentCreator.uploadVideo(selectedVideo);
//                    break;
//                case 4:// add admins
//                    break;
//                case 5:// settings
//                    break;
//                case 6:// open dashBoard
//                    break;
//                case 7://logout
//                    return;
//            }
        }
    }
    public static void viewer(Viewer viewer){
        while (true){
            viewer.getApplication().display();
            int userInputInt = CustomScanner.scanInt("2 refresh\n3 search");
            switch (userInputInt){
                case 1:
                    viewer.selectVideoAndWatch(1);
                    break;
                case 2:// refresh
                    viewer.refresh();
                    break;
                case 3:// search
//                    List <Thumbnail> videosList = viewer.search(CustomScanner.scanString("search...?"));

                    break;
            }
        }
    }
}