package GUI;

import ApplicationLogic.Instructor;
import ApplicationLogic.Student;
import ApplicationLogic.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.collections.*;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;

import Storage.DatabaseManager;
public class RegisterPage {

     static Scene scene;

     public static void start(){
    	
    	 DatabaseManager dbms = new DatabaseManager();

         BorderPane border = new BorderPane();
         border.setStyle("-fx-background: #FFFFFF;");
         VBox centerMenu = new VBox();
         centerMenu.setStyle("-fx-background: #FFFFFF;");
         centerMenu.setPadding(new Insets(10));
         centerMenu.setSpacing(8);
         centerMenu.setAlignment(Pos.TOP_CENTER);

         String fontFamily = "Helvetica";
         double titleFontSize = 48;

         Text scenetitle1 = new Text("MASTERING");
         scenetitle1.setFill(Color.BLUE);
         scenetitle1.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));

         Text scenetitle2 = new Text(" BILKENT");
         scenetitle2.setFill(Color.RED);
         scenetitle2.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));

         HBox logo = new HBox();
         logo.setPadding(new Insets(10));
         logo.setSpacing(8);
         logo.setAlignment(Pos.TOP_CENTER);
         logo.getChildren().addAll(scenetitle1, scenetitle2);

         centerMenu.getChildren().addAll(logo);
         border.setTop(centerMenu);
         //Grid
         GridPane grid = new GridPane();
         grid.setAlignment(Pos.TOP_CENTER);
         grid.setHgap(30);
         grid.setVgap(30);
         grid.setPadding(new Insets(25, 25, 25, 25));
         grid.setStyle("-fx-background: #FFFFFF;");

         //user name
         Label userName = new Label("Enter Your Name:");
         grid.add(userName, 0, 1);
         TextField userNameTextField = new TextField();
         userNameTextField.setPrefWidth(10);
         grid.add(userNameTextField, 1, 1);


         //user surname
         Label userSurname = new Label("Enter Your Surname:");
         grid.add(userSurname, 0, 2);
         TextField userSurnameTextField = new TextField();
         grid.add(userSurnameTextField, 1, 2);
 
         //user email
         Label userEmail = new Label("Enter Your E-mail:");
         grid.add(userEmail, 0, 3);
         TextField userEmailTextField = new TextField();
         grid.add(userEmailTextField, 1,3);

         //user choose password
         Label pw = new Label("Enter Your Password:");
         grid.add(pw, 0,4);
         PasswordField pwBox = new PasswordField();
         grid.add(pwBox, 1,4);

         //user re enter password
         Label repw = new Label("Re-Enter Your Password:");
         grid.add(repw, 0,5);
         PasswordField repwBox = new PasswordField();
         grid.add(repwBox, 1,5);

         //user department
         Label userDepartment = new Label("Department:");
         grid.add(userDepartment, 0,6);
         TextField userDepartmentTextField = new TextField();
         grid.add(userDepartmentTextField, 1,6);
        
         Label schoolYear = new Label("School Year For Students(1 to 4):");
         grid.add(schoolYear, 0,7);
         TextField schoolYearTextField = new TextField();
         grid.add(schoolYearTextField, 1,7);
 
         Button registerButton = new Button("Complete Registration");
         grid.add( registerButton, 1,8);
    
         Hyperlink backHyper = new Hyperlink("Return to Login Page");
         grid.add(backHyper, 1, 9);
         backHyper.setOnAction(e-> {
            LoginApp.myStage.setScene(LoginApp.scene);
            LoginApp.myStage.setTitle("Mastering Bilkent");
         });


         // ApplicationLogic.User Roles:
         ObservableList<String> userRoles =FXCollections.observableArrayList( "a Student","an Instructor");
         ComboBox<String> userRolesBox = new ComboBox<String>(userRoles);
         ComboBox<String> titleBox = new ComboBox<String>();
         userRolesBox.setPromptText("I am");
         grid.add( userRolesBox, 0, 0);

         userRolesBox.setOnAction((event)->{
             String role = (String) userRolesBox.getSelectionModel().getSelectedItem();
             titleBox.setPromptText( "My Title is");
             if( role.equals("a Student")){
                 //ApplicationLogic.User Status for ApplicationLogic.Student:
                 ObservableList<String> studentStatus = FXCollections.observableArrayList( "Undergraduate", "Graduate", "None"   );
                 titleBox.setItems(studentStatus);
             }
             else{
                 ObservableList<String> instructorStatus = FXCollections.observableArrayList( "Prof.","Assoc. Prof", "Asst. Prof", "Instructor");
                 titleBox.setItems(instructorStatus);
             }
             grid.add( titleBox, 1,0);
         });
        
         registerButton.setOnAction((event)->{
        
        	 String uName, uSurname, uPassword,uRePassword, uEmail, uInst, uDept, uRole, uTitle, uYear;
        	 int error = 1;
        	 uName = userNameTextField.getText();
			 if(uName.equals("")){
				 userName.setTextFill(Color.RED);
				 userNameTextField.setPromptText("Please Enter a Name");
				 error = -1;
        	 }
        	 uSurname = userSurnameTextField.getText();
        	 if(uSurname.equals("")){
			     userSurname.setTextFill(Color.RED);
				 userSurnameTextField.setPromptText("Please Enter a Surname");
				 error = -1;
			 }
        	 uPassword = pwBox.getText();
        	 if(uPassword.equals("")){
			  	 pw.setTextFill(Color.RED);
				 pwBox.setPromptText("Please Enter a Surname");
				 error = -1;
        	 }
        	 uRePassword = repwBox.getText();
        	 if(uRePassword.equals("")){
				 repw.setTextFill(Color.RED);
				 repwBox.setPromptText("Please Enter Your Password Again");
				 error = -1;
        	 }
        	 if(!(uPassword.equals(uRePassword))){
        		 repw.setTextFill(Color.RED);
				 repwBox.setPromptText("Wrong Password is Entered");
				 error = -1;
        	 }
        	 uEmail = userEmailTextField.getText();
        	 if(uEmail.equals("")){
				 userEmail.setTextFill(Color.RED);
				 userEmailTextField.setPromptText("Please Enter Your Email Address");
				 error = -1;
        	 }
        	 uDept = userDepartmentTextField.getText();
        	 if(uDept.equals("")){
				 userDepartment.setTextFill(Color.RED);
				 userDepartmentTextField.setPromptText("Please Enter Your Department");
				 error = -1;
        	 }
        	 uRole = (String) userRolesBox.getSelectionModel().getSelectedItem();
        	 if(uRole == null||!(uRole.equals("a Student")||uRole.equals("an Instructor"))){
           		 error = -1;
        	 }
        	 uTitle = (String) titleBox.getSelectionModel().getSelectedItem();
        	 if(uTitle == null||uTitle.equals("")){
        		 error = -1;
        	 }
        	 uYear = (String) schoolYearTextField.getText();
        	 uInst = "Bilkent University";
        	 if(error==-1)
        		 return;
        	

        	 if(uRole.equals("a Student")){
        		 User newUser = new Student(uName, uSurname, uPassword, uEmail, uInst, uDept, "student", uTitle, uYear, "Spring 2017");
        		 Main.arr.add(newUser);
        		
        		 try {
        			 if( !dbms.isExistingStudent(uEmail, uPassword))
        				 dbms.insertToStudent(uName, uSurname, uPassword, uEmail, uInst, uDept,"student", uTitle, uYear, "Spring 2017");
        			 else
        				 System.out.println("Existing Student!");
				 } catch (Exception e1) {
					 // TODO Auto-generated catch block
					 e1.printStackTrace();
				 }
        	 } 
        	 else if(uRole.equals("an Instructor")){
        		 User newUser = new Instructor(uName, uSurname, uPassword, uEmail, uInst, uDept, "instructor", uTitle);
        		 Main.arr.add(newUser);
        		
        		 try {
        			 if( !dbms.isExistingInstructor(uEmail, uPassword))
        				 dbms.insertToInstructor(uName, uSurname, uPassword, uEmail, uInst, uDept,"instructor", uTitle);
        			 else
        				 System.out.println("Existing Instructor!");
				 } catch (Exception e1) {
					 // TODO Auto-generated catch block
					 e1.printStackTrace();
				 }
        	 }
        	
        	 else{
        		 return;
        	 }
        	
        	 LoginApp.myStage.setScene(LoginApp.scene);
        	
        	 for(int i = 0; i < Main.arr.size(); i++)
           	  System.out.println("Users: " + Main.arr.get(i).getUserName());
        	
         });

         border.setCenter(grid);
         scene = new Scene(border);
     }

     public static Scene startScene() {
         start();
         return scene;
     }
}
    
