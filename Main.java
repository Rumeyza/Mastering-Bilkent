package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Homepage");

        HBox topMenu = new HBox();
        //Text labelText = new Text(10, 20, "Mastering Bilkent Student Home Page");
        final Label label = new Label("Mastering Bilkent Student Home Page");
        label.setTextAlignment(TextAlignment.LEFT);
        topMenu.getChildren().addAll(label);

        VBox leftMenu = new VBox();
        leftMenu.setPadding(new Insets(10));
        leftMenu.setSpacing(8);

        Image image = new Image("file:/c:/Users/Asus/workspace/Homepage Example/avatar.png");
        ImageView iv1 = new ImageView();
        iv1.setFitWidth(50);
        iv1.setFitHeight(50);
        iv1.setImage(image);
        //ImageView iv1 = new ImageView(new Image("C:UsersAsusworkspaceHomepage Exampleavatar.png"));

        Text text2 = new Text(10, 20, "Furkan Arif Bozdağ");
        Text text3 = new Text(10, 20, "Bilkent University");
        Text text4 = new Text(10, 20, "CS");
        Text text5 = new Text(10, 20, "Undergraduate");
        Text text6 = new Text(10, 20, "arif.bozdag@ug.bilkent.edu.tr");

        Button buttonD = new Button("Main Page");
        Button buttonE = new Button("My Courses");
        Button buttonF = new Button("Profile");
        Button buttonG = new Button("Send Feedback");
        Button buttonH = new Button("Settings");

        final TextField searchfield = new TextField();
        searchfield.setPromptText("Find Course");
        searchfield.setPrefColumnCount(10);
        searchfield.getText();

        leftMenu.getChildren().addAll(iv1, text2, text3, text4, text5 ,text6 ,
                buttonD, buttonE, buttonF, buttonG, buttonH, searchfield);

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(topMenu);
        borderpane.setLeft(leftMenu);


        StackPane layout = new StackPane();
        Scene scene = new Scene(borderpane , 800, 800);
        window.setScene(scene);
        window.show();
    }


}