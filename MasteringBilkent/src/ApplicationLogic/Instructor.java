package ApplicationLogic;

import java.util.ArrayList;

/**
 * Created by Asus on 3.5.2017.
 */
public class Instructor extends User {


    public ArrayList<Content> courseList;

    public Instructor(){
        super();
        this.courseList = new ArrayList<Content>();
    }

    public Instructor(String name, String surname, String pass, String email, String inst, String dept, String role, String title) {
        super(name, surname, pass, email, inst, dept, role, title);
    }

    public boolean createCourse(String contentname, String key, boolean v){
        for(int i = 0; i < courseList.size() ; i++){
            if(courseList.get(i).getContentName().equals(contentname))
                return false;
        }
        Content course = new Course( contentname,  super.getUserName(),  key,  v);
        courseList.add(course);
        return true;

    }

    public boolean deleteCourse(int courseId){
        for(int i = 0; i < courseList.size() ; i++){
            if(courseList.get(i).getContentId() == courseId)
                courseList.remove(courseId);
            return true;
        }
        return false;
    }
}
