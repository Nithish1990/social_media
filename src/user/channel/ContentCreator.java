package user.channel;

import application.utilities.constant.country.Country;

public class ContentCreator{


    public ContentCreator(String name, String emailId, String password, String number, String dob, Country Country) {
        super();
    }


////    methods
//
//    public void switchToChannel(){
//        currentChannel = channelList.get(0);
//    }
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
