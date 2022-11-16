package user;

import application.constant.category.Category;
import application.generator.Generator;
import application.video.Thumbnail;

import java.util.ArrayList;
import java.util.List;

public class Channel{
    public String channelName;
    private boolean isBannedChannel;
    private final String channelUrl;
    private String about;
    private Category category;
    private boolean monetized;
    private long amountEarned;
    private int subscribersCount;
    private List<User> haveAccess;
    private List<Thumbnail> uploadedVideo;



    //constructor

    public Channel(String channelName, String about,Category category,ContentCreator contentCreator) {

        this.channelName = channelName;
        this.isBannedChannel = false;
        this.channelUrl = Generator.urlGenerate(1,channelName);
        this.about = about;
        this.category = category;
        this.monetized = false;
        this.amountEarned = 0;
        this.subscribersCount = 0;
        this.haveAccess = new ArrayList<>();
        this.uploadedVideo = new ArrayList<>();
    }
}
