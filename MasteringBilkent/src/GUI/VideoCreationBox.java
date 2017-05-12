package GUI;
import ApplicationLogic.Content;
import ApplicationLogic.Course;
import ApplicationLogic.Instructor;
import ApplicationLogic.Student;
import ApplicationLogic.User;
import Storage.DatabaseManager;
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


public class VideoCreationBox {


    public static void display(Course course, User user){
    	DatabaseManager dbms = new DatabaseManager();
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New Course");
        window.setWidth(600);
        window.setHeight(400);

        //New Course Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");

        //Course Name
        Label courseName = new Label("Enter Video Name:");
        grid.add(courseName, 0, 1);
        TextField courseNameTextField = new TextField();
        courseNameTextField.setPrefWidth(10);
        grid.add(courseNameTextField, 1, 1, 8, 1);


        Label courseKey = new Label("Enter Video URL:");
        grid.add(courseKey, 0, 2);
        TextField courseKeyTextField = new TextField();
        grid.add(courseKeyTextField, 1, 2 ,8 ,1);
       
        Button create = new Button("Add Video");
        grid.add(create, 4,4);

        create.setOnAction((event)->{
            
        	String cName, cKey;
        	int error = 1;
        	cName = courseNameTextField.getText();
			if(cName.equals("")){
				courseName.setTextFill(Color.RED);
				courseNameTextField.setPromptText("Please Enter a Name");
				error = -1;
        	}
        	cKey = courseKeyTextField.getText();
        	if(cKey.equals("")){
				courseKey.setTextFill(Color.RED);
				courseKeyTextField.setPromptText("Please Enter a Video URL");
				error = -1;
			}
        	if(error==-1)
        		return;
        	
        	else{
        		int crsId=0;
				try {
					crsId = dbms.getCourseId(course.getContentName());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		try {
        			dbms.insertToVideo(crsId,cName, cKey );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		LoginApp.myStage.setScene(CoursePage.startScene(course, user));
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
