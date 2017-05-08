package GUI;

import ApplicationLogic.Course;
import ApplicationLogic.User;
import javafx.application.Application;
import java.util.ArrayList;

public class Main {
    
    static ArrayList<User> arr;
    static ArrayList<Course> courseArr;
    
    public static void main(String[] args) {
        
        User user1 = new User("Root","Mastering Bilkent","a","a","","","",""); //root@mastering.bilkent
        arr = new ArrayList<User>();
        arr.add(0,user1);
        
        Course OOD = new Course("CS319 - Object Oriented Software Engineering " , "Bora Güngören");
        Course PL = new Course("CS315 - Programming Languages " , "Buğra Gedik");
        courseArr = new ArrayList<Course>();
        courseArr.add(0, OOD);
        courseArr.add(1, PL);

        
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
    public static int findUser(String userName, String password){
        int result = -1;
        for(int i = 0; i < Main.arr.size() ; i++){
            if(Main.arr.get(i).getUserEmail().equals(userName)&& Main.arr.get(i).getUserPassword().equals(password))
                result = i;
        }
        return result;
    }
}
