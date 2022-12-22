package user;

public class VideoClip {
    public String name;
    public int duration;
    public int size;


    public VideoClip(){
        this.name = "default";
        this.size = 1;
        this.duration = 1;
    }

    public VideoClip(String name, int duration, int size) {
        this.name = name;
        this.duration = duration;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
