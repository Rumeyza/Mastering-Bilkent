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
        window.setWidth(300);
        window.setHeight(300);

        //New Course Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");

       


        Hyperlink quizContent = new Hyperlink("Create Quiz");
        grid.add(quizContent, 0, 1);
        Hyperlink videoContent = new Hyperlink("Upload Video");
        grid.add(videoContent, 0, 2);
        Hyperlink pdfBox = new Hyperlink("Upload Text Document");
        grid.add(pdfBox, 0, 3);
     
      
   

        
        grid.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

    }
}
