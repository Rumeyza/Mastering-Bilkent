package GUI;

import ApplicationLogic.Content;
import ApplicationLogic.Course;
import ApplicationLogic.Instructor;
import ApplicationLogic.Student;
import ApplicationLogic.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ContentSelectionBox {
  public static void display(Course course, User user){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Course Key");
        window.setWidth(600);
        window.setHeight(300);

        //New Course Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");

       


        Label courseKey = new Label("Enter Course Key:");
        grid.add(courseKey, 0, 2);
        TextField courseKeyTextField = new TextField();
        grid.add(courseKeyTextField, 1, 2 ,8 ,1);
     
       
        Button create = new Button("OK");
        grid.add(create, 4,4);

        create.setOnAction((event)->{
            
        	String cKey;
        	int error = 1;
        	
        	cKey = courseKeyTextField.getText();
        	if(cKey.equals("")){
				courseKey.setTextFill(Color.RED);
				courseKeyTextField.setPromptText("Please Enter a Course Key");
				error = -1;
			}
        	else if(cKey.equals(course.getCourseKey())){
        		LoginApp.myStage.setScene(CoursePage.startScene(course, user));	
        	}
        	else{
        		error = -1;
        	}
        	
        	if(error==-1)
        		return;
  
        	else{
        		window.close();
        		return;
        	}
     	
        });
        grid.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

    }
}
