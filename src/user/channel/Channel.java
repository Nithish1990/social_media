package user.channel;

import application.user.ViewerProfile;
import application.utilities.constant.category.Category;
import application.utilities.generator.Generator;
import application.video.Thumbnail;
import application.video.Video;
import user.User;
import user.channel.members.Member;

import java.nio.channels.UnresolvedAddressException;
import java.util.ArrayList;
import java.util.List;

public class Channel{
    private String channelName;
    private boolean isBannedChannel;
    private final String channelUrl;
    private String about;
    private Category category;
    private boolean monetized;
    private long amountEarned;
    private int subscribersCount;
    private List<User> haveAccess;
    private List<Thumbnail> uploadedVideo;
    private List<Member> channelMembers;
    private ViewerProfile viewerProfile;
    //constructor

    public Channel(String channelName, String about, Category category, ViewerProfile viewerProfile) {

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
        this.channelMembers = new ArrayList<>();
        this.viewerProfile = viewerProfile;

    }

    // getter setters
    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public boolean isBannedChannel() {
        return isBannedChannel;
    }

    public void setBannedChannel(boolean bannedChannel) {
        isBannedChannel = bannedChannel;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isMonetized() {
        return monetized;
    }

    public void setMonetized(boolean monetized) {
        this.monetized = monetized;
    }

    public long getAmountEarned() {
        return amountEarned;
    }

    public void setAmountEarned(long amountEarned) {
        this.amountEarned = amountEarned;
    }

    public int getSubscribersCount() {
        return subscribersCount;
    }

    public void setSubscribersCount(int subscribersCount) {
        this.subscribersCount = subscribersCount;
    }

    public List<User> getHaveAccess() {
        return haveAccess;
    }

    public void setHaveAccess(List<User> haveAccess) {
        this.haveAccess = haveAccess;
    }

    public List<Thumbnail> getUploadedVideo() {
        return uploadedVideo;
    }

    public void setUploadedVideo(List<Thumbnail> uploadedVideo) {
        this.uploadedVideo = uploadedVideo;
    }
}
