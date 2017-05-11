package ApplicationLogic;

import java.util.ArrayList;

/**
 * Created by Asus on 3.5.2017.
 */
public class Course extends Content {

    private int instructorId;
    private String courseKey;
    private boolean visibility;
    public ArrayList<Content> contentList;

    public Course() {
        super("Default Course");
        this.instructorId = 0;;
        this.courseKey = null;
        this.visibility = true;
    }

    public Course(String contentName, int instr, String key, boolean v)
    {
        super(contentName);
        this.instructorId = instr;
        this.courseKey = key;
        this.visibility = v;
    }

    public Course(String contentName, int instr, boolean v)
    {
        super(contentName);
        this.instructorId = instr;
        this.courseKey = null;
        this.visibility = v;
    }

    public Course(String contentName, int instr)
    {
        super(contentName);
        this.instructorId = instr;
        this.courseKey = null;
        this.visibility = true;
    }

    //getters and setters
    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructor) {
        this.instructorId = instructor;
    }

    public String getCourseKey() {
        return courseKey;
    }

    public void setCourseKey(String courseKey) {
        this.courseKey = courseKey;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public void addContent(){

    }

    @Override
    public String toString() {
        return "Course{" +
                "instructor='" + instructorId + '\'' +
                ", courseKey='" + courseKey + '\'' +
                ", visibility=" + visibility +
                ", contentList=" + contentList +
                '}';
    }
}
