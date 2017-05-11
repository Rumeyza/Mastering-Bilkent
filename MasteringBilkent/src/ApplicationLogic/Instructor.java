package ApplicationLogic;

import GUI.Main;

import java.util.ArrayList;
import Storage.DatabaseManager;
/**
 * Created by Asus on 3.5.2017.
 */
public class Instructor extends User {

	DatabaseManager dbms = new DatabaseManager();
    //public static ArrayList<Course> courseList;

    //Constructors
    public Instructor(){
        super();
        //this.courseList = new ArrayList<Course>();
    }

    public Instructor(String name, String surname, String pass, String email, String inst, String dept, String role, String title) {
        super(name, surname, pass, email, inst, dept, role, title);
        //this.courseList = new ArrayList<Course>();
    }

    //getter setter
   // public ArrayList<Course> getCourseList() {return courseList;}

    //public void setCourseList(ArrayList<Course> courseList) {this.courseList = courseList;}

    //Other methods
    public boolean createCourse(String coursename, String key, boolean v) throws Exception{
        
        //add
        int id = dbms.getInstructorId(super.getUserEmail(), super.getUserPassword());
        
        try {
			dbms.insertToCourse(coursename, id, key, v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }

    public void createQuiz(String contentName, int size, String description, boolean graded){
        //insertToQuiz(contentName,size,description,graded);
    }
}
