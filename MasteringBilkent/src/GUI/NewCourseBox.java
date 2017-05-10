package GUI;

import ApplicationLogic.Content;
import ApplicationLogic.Course;
import ApplicationLogic.Instructor;
import ApplicationLogic.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class NewCourseBox {

    public static void display( Instructor inst ){
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
        Label userName = new Label("Enter Course Name:");
        grid.add(userName, 0, 1);

        TextField name = new TextField();
        name.setPrefWidth(10);
        grid.add(name, 1, 1);

        Button create = new Button("Add Course");
        grid.add( create, 1,2);

        create.setOnAction(e -> {
            inst.createCourse(name.getText(),"1234", true);
            //System.out.print("Instructor{" + "courseList=" + Instructor.courseList + '}');
            LoginApp.myStage.setScene(InstructorHomePage.startScene(inst));
            window.close();
        });

        grid.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

    }
}
