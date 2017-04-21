import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.collections.*;
import javafx.scene.control.ComboBox;
 

public class RegisterPage {

    static Scene scene;

    public static void start() {

        //Grid
    	 GridPane grid = new GridPane();
         grid.setAlignment(Pos.TOP_LEFT);
         grid.setHgap(100);
         grid.setVgap(30);
         grid.setPadding(new Insets(25, 25, 25, 25));
         grid.setStyle("-fx-background: #FFFFFF;");

        //TITLE
         String fontFamily = "Helvetica";
         double titleFontSize = 48;

         TextFlow textFlow = new TextFlow();
         
         Text scenetitle1 = new Text("MASTERING");
         scenetitle1.setFill(Color.BLUE);
         scenetitle1.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));
         Text scenetitle2 = new Text(" BILKENT");
         scenetitle2.setFill(Color.RED);
         scenetitle2.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));
         
         textFlow.getChildren().addAll(scenetitle1, scenetitle2);
         
         grid.add(textFlow, 2, 0);
        //user name
         Label userName = new Label("Enter Your Name:");
         grid.add(userName, 1, 2);
         TextField userNameTextField = new TextField();
         grid.add(userNameTextField, 2, 2);

        //user surname
         Label userSurname = new Label("Enter Your Surname:");
         grid.add(userSurname, 1, 3);
         TextField userSurnameTextField = new TextField();
         grid.add(userSurnameTextField, 2, 3);
         
        //user email
         Label userEmail = new Label("Enter Your E-mail:");
         grid.add(userEmail, 1, 4);
         TextField userEmailTextField = new TextField();
         grid.add(userEmailTextField, 2, 4);

        //user choose password
         
         Label pw = new Label("Enter Your Password:");
         grid.add(pw, 1, 5);
         PasswordField pwBox = new PasswordField();
         grid.add(pwBox, 2, 5);

        //user re enter password
         Label repw = new Label("Re-Enter Your Password:");
         grid.add(repw, 1, 6);
         PasswordField repwBox = new PasswordField();
         grid.add(repwBox, 2, 6);

        //user department
         Label userDepartment = new Label("Institution:");
         grid.add(userDepartment, 1, 7);
         TextField userDepartmentTextField = new TextField();
         grid.add(userDepartmentTextField, 2, 7);
         

         Button registerButton = new Button("Complete Registration");         
         grid.add( registerButton, 2, 8);
         
         // User Roles:
         ObservableList<String> userRoles = 
         	    FXCollections.observableArrayList(
         	        "a Student",
         	        "an Instructor"
         	    );
         	final ComboBox<String> userRolesBox = new ComboBox<String>(userRoles);
         	userRolesBox.setPromptText("I am");
         	grid.add( userRolesBox, 3, 3);
         	
         	userRolesBox.setOnAction((event)->{
         		String role = (String) userRolesBox.getSelectionModel().getSelectedItem();
         		if( role == "a Student"){    	        	  
         	        //User Status for Student:
         	        ObservableList<String> studentStatus = 
         	        	    FXCollections.observableArrayList( "Undergraduate", "Graduate", "None"   );
         	        final ComboBox<String> studentStatusBox = new ComboBox<String>(studentStatus);
         	        studentStatusBox.setPromptText( "My Ünvan is");
         	        grid.add( studentStatusBox, 3, 4);
         		}
         		else{
         	        ObservableList<String> instructorStatus = 
         	        	    FXCollections.observableArrayList( "Prof.","Assoc. Prof", "Asst. Prof", "Instructor");
         	        final ComboBox<String> instructorStatusBox = new ComboBox<String>(instructorStatus);
         	        instructorStatusBox.setPromptText( "My Ünvan is");
         	        grid.add( instructorStatusBox, 3, 4);
         		}
         	});


        scene = new Scene(grid);
    }

    public static Scene startScene() {
        start();
        return scene;
    }
}
    