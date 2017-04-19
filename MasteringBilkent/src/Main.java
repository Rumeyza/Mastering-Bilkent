package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application{

    Scene scene1, scene2;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Homepage");

        //Center
        VBox centerMenu = new VBox();
        centerMenu.setPadding(new Insets(10));
        centerMenu.setSpacing(8);
        centerMenu.setAlignment(Pos.TOP_CENTER);

        Text text1 = new Text(10, 20, "Mastering Bilkent Student Home Page");

        Hyperlink buttonA = new Hyperlink("Register Another Course");
        centerMenu.getChildren().addAll(text1, buttonA);

        //Left
        VBox leftMenu = new VBox();
        leftMenu.setPadding(new Insets(10));
        leftMenu.setSpacing(8);

        //user information grid
        GridPane infogrid = new GridPane();
        infogrid.setPadding(new Insets(10,10,10,10));
        infogrid.setVgap(8);
        infogrid.setHgap(10);

        Image avatar = new Image("file:/c:/Users/Asus/workspace/Homepage Example/avatar.png");
        ImageView iv1 = new ImageView();
        iv1.setFitWidth(80);
        iv1.setFitHeight(100);
        iv1.setImage(avatar);
        GridPane.setConstraints(iv1, 0,0,1,3);
        
        Text text2 = new Text(10, 20, "Furkan Arif Bozdağ");
        GridPane.setConstraints(text2, 1,0,2,1);
        
        Text text3 = new Text(10, 20, "Bilkent University");
        GridPane.setConstraints(text3, 1,1,2,1);
        
        Text text4 = new Text(10, 20, "CS /");
        GridPane.setConstraints(text4, 1,2);
        
        Text text5 = new Text(10, 20, "Undergraduate");
        GridPane.setConstraints(text5, 2,2);
        
        Text text6 = new Text(10, 20, "arif.bozdag@ug.bilkent.edu.tr");
        GridPane.setConstraints(text6, 0,3,3,3);

        infogrid.getChildren().addAll(iv1, text2, text3, text4, text5, text6);

        //navigator list

        Hyperlink link1 = new Hyperlink("Main Page");
        //link1.setOnAction(e -> );
        
        Hyperlink link2 = new Hyperlink("My Courses");
        //link2.setOnAction(e -> );
        
        Hyperlink link3 = new Hyperlink("Profile");
        link3.setOnAction(e -> primaryStage.setScene(scene2));
        
        Hyperlink link4 = new Hyperlink("Send Feedback");
        link4.setOnAction(e -> AlertBox.display("contact","mastering@bilkent.edu.tr"));
        
        Hyperlink link5 = new Hyperlink("Settings");
        //link5.setOnAction(e -> );

        //search bar
        final TextField searchfield = new TextField();
        searchfield.setPromptText("Find Course");
        searchfield.setPrefColumnCount(10);
        searchfield.getText();

        leftMenu.getChildren().addAll( infogrid, link1, link2, link3, link4, link5, searchfield);

        //border pane finalizer
        BorderPane layout1 = new BorderPane();
        layout1.setCenter(centerMenu);
        layout1.setLeft(leftMenu);

        //SCENE 1 -> HOME PAGE
        scene1 = new Scene(layout1);
        primaryStage.setScene(scene1);

        //SCENE 2 -> PROFİLE PAGE
        Hyperlink buttonlayout2 = new Hyperlink("Turn back nothing here :/");
        buttonlayout2.setOnAction(e -> primaryStage.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(buttonlayout2);
        scene2 = new Scene(layout2);

        //for fullscreen stage
        Screen screen1 = Screen.getPrimary();
        Rectangle2D bounds = screen1.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        primaryStage.show();
    }

}
