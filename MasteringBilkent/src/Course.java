
/**
 * Created by Asus on 3.5.2017.
 */
public class Course extends Content {

    public String instructor;
    public String courseKey;
    public boolean visibility;
    //public String[] contentList;

    public Course() {
        super();
        this.instructor = "Default Instructor";
        this.courseKey = null;
        this.visibility = true;
    }

    public Course(String contentName, String instr, String key, boolean v)
    {
        super(contentName);
        this.instructor = instr;
        this.courseKey = key;
        this.visibility = v;
    }

    public Course(String contentName, String instr, boolean v)
    {
        super(contentName);
        this.instructor = instr;
        this.courseKey = null;
        this.visibility = v;
    }

    public Course(String contentName, String instr)
    {
        super(contentName);
        this.instructor = instr;
        this.courseKey = null;
        this.visibility = true;
    }

    //getters and setters
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
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
}
