package sample;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    static Stage outStage;
    static ArrayList<User> arr;

    @Override
    public void start(Stage primaryStage) throws Exception{

        User user1 = new User();
        User user2 = new User("Ertan", "Aday", "12345", "ertan.aday@ug.bilkent.edu.tr",
                "Bilkent University", "CS", "Undergraduate");
        arr = new ArrayList<User>();
        arr.add(0,user1);
        arr.add(1,user2);

        primaryStage.setTitle("Mastering Bilkent");
        primaryStage.setScene(LoginApp.startScene());

        //for fullscreen
        Screen screen1 = Screen.getPrimary();
        Rectangle2D bounds = screen1.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        outStage = primaryStage;
        outStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
