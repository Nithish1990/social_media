package application.video;

import application.utilities.constant.category.AgeCategory;
import application.utilities.constant.category.Category;
import application.utilities.generator.Generator;
import user.Channel;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Video {
    private static int Vid;
    private String videoTitle;
    public final Channel channel;
    private final String url;
    private String description;
    private boolean visibility;
    private AgeCategory ageCategory;
    public final Time duration;
    public LocalDateTime uploadedDateAndTime;
    private int likesCount;
    private int dislikesCount;
    private Stack<String> comments;
    private int viewsCount;
    private int violationCount;
    private Category category;
    private List<String> tags;
    private List<String> reportList;
    private Thumbnail thumbnail;


    public Video(String videoTitle, Channel channel,String description, boolean visibility, AgeCategory ageCategory, Time duration,
                 Category category, List<String> tags, Thumbnail thumbnail) {

        this.videoTitle = videoTitle;
        this.channel = channel;
        this.url = Generator.urlGenerate(1,channel.channelName);
        this.description = description;
        this.visibility = visibility;
        this.ageCategory = ageCategory;
        this.category = category;
        this.duration = duration;
        this.uploadedDateAndTime= LocalDateTime.now();
        this.likesCount = 0;
        this.dislikesCount = 0;
        this.comments = new Stack<>();
        this.viewsCount = 0;
        this.violationCount = 0;
        this.tags = tags;
        this.reportList = new ArrayList<>();
        this.thumbnail = new Thumbnail(videoTitle,channel,duration,uploadedDateAndTime,url);
    }
}
