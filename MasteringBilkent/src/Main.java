
import javafx.application.Application;
import java.util.ArrayList;

public class Main {
    static ArrayList<User> arr;
    public static int findUser(String userName, String password){
    	int result = -1;
    	for(int i = 0; i < Main.arr.size() ; i++){
    		if(Main.arr.get(i).getUserEmail().equals(userName)&& Main.arr.get(i).getUserPassword().equals(password))
    			result = i;
    	}
    	return result;
    }

    public static void main(String[] args) {
         User user1 = new User("Root","Mastering Bilkent","root","root@mastering.bilkent","","","","");
         arr = new ArrayList<User>();
         arr.add(0,user1);
         Application.launch(LoginApp.class, args);
    }
}