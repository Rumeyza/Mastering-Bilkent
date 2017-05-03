
import javafx.application.Application;
import java.util.ArrayList;

public class Main {
    
    static ArrayList<User> arr;
    static ArrayList<Content> contArr;
    
    public static void main(String[] args) {
        
        User user1 = new User("Root","Mastering Bilkent","a","a","","","",""); //root@mastering.bilkent
        arr = new ArrayList<User>();
        arr.add(0,user1);
        
        Content OOD = new Course("Object Oriented Design - CS319" , "Bora Güngören");
        contArr = new ArrayList<Content>();
        contArr.add(0, OOD);
        
        Application.launch(LoginApp.class, args);
    }

    public static int findContent(int contId){
        int result = -1;
        for(int i = 0; i < Main.contArr.size() ; i++){
            if(Main.contArr.get(i).contentId == contId)
                result = i;
        }
        return result;
    }
    
    public static int findUser(String userName, String password){
        int result = -1;
        for(int i = 0; i < Main.arr.size() ; i++){
            if(Main.arr.get(i).getUserEmail().equals(userName)&& Main.arr.get(i).getUserPassword().equals(password))
                result = i;
        }
        return result;
    }
}
