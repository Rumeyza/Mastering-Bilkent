
/**
 * Created by Asus on 3.5.2017.
 */
public class Content {

    public static int contID = 1000;

    public String contentName;
    public int contentId;

    public Content(){
        this.contentName = "Default Content";
        this.contentId = contID++;
    }

    public Content(String contentName) {
        this.contentName = contentName;
        this.contentId = contID++;
    }

    //getter and setters
    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }
}