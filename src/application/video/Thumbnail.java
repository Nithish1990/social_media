package application.video;

import user.Channel;

import java.sql.Time;
import java.time.LocalDateTime;

public class Thumbnail {
    private String videoTitle;
    private final Channel channel;
    private final Time duration;
    private final LocalDateTime uploadedDateAndTime;
    private final String url;

    public Thumbnail(String videoTitle, Channel channel, Time duration, LocalDateTime uploadedDateAndTime, String url) {
        this.videoTitle = videoTitle;
        this.channel = channel;
        this.duration = duration;
        this.uploadedDateAndTime = uploadedDateAndTime;
        this.url = url;
    }

    //  methods
    public void redirect(){}


    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Channel getChannel() {
        return channel;
    }

    public Time getDuration() {
        return duration;
    }

    public LocalDateTime getUploadedDateAndTime() {
        return uploadedDateAndTime;
    }

    public String getUrl() {
        return url;
    }
}
