
import javafx.application.Application;
import java.util.ArrayList;

public class Main {
    static ArrayList<User> arr;

    public static void main(String[] args) {
    	 User user1 = new User();
         User user2 = new User("Ertan", "Aday", "12345", "ertan.aday@ug.bilkent.edu.tr","Bilkent University", "CS", "Undergraduate");
         arr = new ArrayList<User>();
         arr.add(0,user1);
         arr.add(1,user2);
         Application.launch(LoginApp.class, args);
    }
}