
import java.util.ArrayList;

/**
 * Created by Asus on 3.5.2017.
 */
public class Student extends User{

    public String schoolYear;
    public String semester;
    public ArrayList<Integer> courseEnrolmentList;

    public Student(String name, String surname, String pass, String email, String inst, String dept, String role, String title,
                   String schoolYear, String semester) {
        super(name, surname, pass, email, inst, dept, role, title);
        this.schoolYear = schoolYear;
        this.semester = semester;
        this.courseEnrolmentList = new ArrayList<Integer>();
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getEnrolment(int Index){
        return courseEnrolmentList.get(Index);
    }

    public void enrollCourse(int courseId){
        //---------------->course student list update logic
        if(!courseEnrolmentList.contains(courseId))
        courseEnrolmentList.add(courseId);
    }

    public void enrollCourse(int courseId, int courseKey){
        //---------------->course student list update logic with a key
        if(!courseEnrolmentList.contains(courseId))
            courseEnrolmentList.add(courseId);
    }

    public void leaveCourse(int courseId){
        if(courseEnrolmentList.contains(courseId))
            courseEnrolmentList.remove(courseId);
    }

}
