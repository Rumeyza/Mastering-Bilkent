package GUI;

import ApplicationLogic.Course;
import ApplicationLogic.Instructor;
import ApplicationLogic.User;
import ApplicationLogic.Student;
import javafx.application.Application;
import java.util.ArrayList;

import Storage.DatabaseManager;


public class Main {
    
    public static ArrayList<User> arr;
    public static ArrayList<Course> courseArr;
    
    public static void main(String[] args) throws Exception{
        
    	DatabaseManager dbms = new DatabaseManager();
    	
        User user1 = new User("Root","Mastering Bilkent","a","a","","","",""); //root@mastering.bilkent
        User user2 = new Instructor("b","b","b","b","b","b","an Instructor","b");
        arr = new ArrayList<User>();
        arr.add(0,user1);
        arr.add(1,user2);
        
        dbms.insertToStudent("gulden", "aday", "123", "guldenaday@gmail.com", "bilk", "cs", "grad", "3", "spring 2017");
        Student newStudent = new Student();
        newStudent = dbms.getStudent("guldenaday@gmail.com", "123");
        
        System.out.println(newStudent.getUserEmail());
        
        Course OOD = new Course("CS319 - Object Oriented Software Engineering " , "Bora Güngören");
        Course PL = new Course("CS315 - Programming Languages " , "Buğra Gedik");
        Course OS = new Course("CS342 - Operating Systems " , "Özcan Öztürk");
        Course DB = new Course("CS353 - Database Systems" , "Özgür Ulusoy");
        Course CS101 = new Course("CS101 - Algorithms and Programming 1" , "David Davenport");
        Course CS223 = new Course("CS223 - Digital Design" , "William Sawyer");
        Course CS224 = new Course("CS224 - Computer Organization" , "Fazlı Can");
        Course CS102 = new Course("CS102 - Algorithms and Programming 2" , "Öznur Taştan Okan");
        Course MATH101 = new Course("MATH101 - Calculus 1" , "Okan Tekman");
        Course MATH102 = new Course("MATH102 - Calculus 2" , "Okan Tekman");
        courseArr = new ArrayList<Course>();
        courseArr.add(0, OOD);
        courseArr.add(1, PL);
        courseArr.add(2, OS);
        courseArr.add(3, DB);
        courseArr.add(4, CS101);
        courseArr.add(5, CS223);
        courseArr.add(6, CS224);
        courseArr.add(7, CS102);
        courseArr.add(8, MATH101);
        courseArr.add(9, MATH102);

        
        Application.launch(LoginApp.class, args);
    }


    public static int findCourse(int contId){
        int result = -1;
        for(int i = 0; i < Main.courseArr.size() ; i++){
            if(Main.courseArr.get(i).getContentId() == contId)
                result = i;
        }
        return result;
    }

    //Logic check logic
    public static User findUser(String userName, String password){
        User result = null;
        for(int i = 0; i < Main.arr.size() ; i++){
            if(Main.arr.get(i).getUserEmail().equals(userName)&& Main.arr.get(i).getUserPassword().equals(password))
                result = Main.arr.get(i);
        }
        return result;
    }
}
