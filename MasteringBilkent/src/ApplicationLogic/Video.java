package ApplicationLogic;

/**
 * Created by Asus on 8.5.2017.
 */
public class Video extends Content{

    private String videoUrl;

    public Video(String contentName, String videoUrl) {
        super(contentName);
        this.videoUrl = videoUrl;
    }

    public Video() {
        this.videoUrl = "https://www.youtube.com/embed/UxkCLqFZ0E0?rel=0&amp&autoplay=1;showinfo=0";
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoUrl='" + videoUrl + '\'' +
                '}';
    }
}
