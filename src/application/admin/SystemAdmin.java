package application.admin;

import application.Application;
import application.utilities.generator.RevenueGenerator;
import application.video.Video;
import user.Channel;
import user.User;

import java.util.ArrayList;

public class SystemAdmin {
    private static int id;
    private String adminName;
    private String password;
//    private static Map<String, List<String>> reportDetails = new HashMap<>();
    private Application application;
    private static RevenueGenerator revenueGenerator;


    public void acceptMonetization(Channel channel) {}//-> who can accept the monetization for the channel based on the subscribers
    public void deleteVideo(Video video) {}//-> delete the video from db if he saw violation
    public void banUser(User user){}//-> can ban the user so user cant post anything
    public void sendNotice(User user){}//-> send notice to user for warning as well as appreciate
    public void transferMoney(ArrayList<User> user){}//-> send money to all channels then the channel owner can  withdraw  from revenueGenrator
    //
    public SystemAdmin(String adminName,String password, Application application) {
        this.adminName = adminName;
        this.password = password;
        this.application = application;
    }
}
