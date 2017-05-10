package ApplicationLogic;

import GUI.Main;

import java.util.ArrayList;
import Storage.DatabaseManager;
/**
 * Created by Asus on 3.5.2017.
 */
public class Instructor extends User {

    public static ArrayList<Course> courseList;

    //Constructors
    public Instructor(){
        super();
        this.courseList = new ArrayList<Course>();
    }

    public Instructor(String name, String surname, String pass, String email, String inst, String dept, String role, String title) {
        super(name, surname, pass, email, inst, dept, role, title);
        this.courseList = new ArrayList<Course>();
    }

    //getter setter
    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    //Other methods
    public boolean createCourse(String coursename, String key, boolean v){
        //if course exists ignore
        for(int i = 0; i < courseList.size() ; i++){
            if(courseList.get(i).getContentName().equals(coursename))
                return false;
        }
        //add
        Course MyCourse = new Course( coursename,  super.getUserName(),  key,  v);
        courseList.add(MyCourse);
        Main.courseArr.add(MyCourse);
        
        DatabaseManager dbms = new DatabaseManager();
        try {
			dbms.insertToCourse(coursename, super.getUserName(), key, v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

    public Content returnLastCourse(){
        return courseList.get(courseList.size());
    }

}
