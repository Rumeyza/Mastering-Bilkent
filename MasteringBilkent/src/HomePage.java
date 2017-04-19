package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class HomePage{

    static Scene scene;

    public static void start(){

        //  BORDER PANE COMPONENTS
        //  CENTER
        VBox centerMenu = new VBox();
        centerMenu.setPadding(new Insets(10));
        centerMenu.setSpacing(8);
        centerMenu.setAlignment(Pos.TOP_CENTER);

        //Mastering Bilkent Title
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

        Hyperlink buttonA = new Hyperlink("Register Another Course");

        centerMenu.getChildren().addAll(logo, buttonA);
        //  CENTER END

        //  LEFT
        VBox leftMenu = new VBox();
        leftMenu.setPadding(new Insets(10));
        leftMenu.setSpacing(8);

        //user information grid
        GridPane infogrid = new GridPane();
        infogrid.setPadding(new Insets(10,10,10,10));
        infogrid.setVgap(8);
        infogrid.setHgap(10);

        //profile image
        Image avatar = new Image("file:avatar.png");
        ImageView iv1 = new ImageView();
        iv1.setFitWidth(80);
        iv1.setFitHeight(100);
        iv1.setImage(avatar);
        GridPane.setConstraints(iv1, 0,0,1,3);

        String fontFamily1 = "Helvetica";
        double titleFontSize1 = 19;

        Text text2 = new Text(10, 20, "Furkan Arif Bozdağ");
        text2.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text2, 1,0,2,1);

        Text text3 = new Text(10, 20, "Bilkent University");
        text3.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text3, 1,1,2,1);

        Text text4 = new Text(10, 20, "CS /");
        text4.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text4, 1,2);

        Text text5 = new Text(10, 20, "Undergraduate");
        text5.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text5, 2,2);

        Text text6 = new Text(10, 20, "arif.bozdag@ug.bilkent.edu.tr");
        text6.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text6, 0,3,3,3);

        infogrid.getChildren().addAll(iv1, text2, text3, text4, text5, text6);

        //navigator list

        Hyperlink link1 = new Hyperlink("Main Page");
        //link1.setOnAction(e -> );

        Hyperlink link2 = new Hyperlink("My Courses");
        //link2.setOnAction(e -> );

        Hyperlink link3 = new Hyperlink("Profile");
        link3.setOnAction(e -> {
            LoginApp.outStage.setScene(ProfilePage.startScene());
            LoginApp.outStage.setTitle("Your Profile");
        });

        Hyperlink link4 = new Hyperlink("Send Feedback");
        link4.setOnAction(e -> AlertBox.display("contact","mastering@bilkent.edu.tr"));

        Hyperlink link5 = new Hyperlink("Settings");
        //link5.setOnAction(e -> );

        Hyperlink logoutlink = new Hyperlink("logout");
        logoutlink.setOnAction(e -> {
            LoginApp.outStage.setScene(LoginApp.startScene());
            LoginApp.outStage.setTitle("Mastering Bilkent");
        });

        //search bar
        final TextField searchfield = new TextField();
        searchfield.setPromptText("Find Course");
        searchfield.setPrefColumnCount(10);
        searchfield.getText();

        leftMenu.getChildren().addAll( infogrid, link1, link2, link3, link4, link5,logoutlink, searchfield);
        leftMenu.setAlignment(Pos.CENTER_LEFT);
        //  LEFT END

        //  BORDER PANE
        BorderPane layout1 = new BorderPane();
        layout1.setCenter(centerMenu);
        layout1.setLeft(leftMenu);
        layout1.setStyle("-fx-background: #FFFFFF;");

        scene = new Scene(layout1);

        /*SCENE 2 -> PROFİLE PAGE
        Hyperlink buttonlayout2 = new Hyperlink("Turn back nothing here :/");
        buttonlayout2.setOnAction(e -> primaryStage.setScene(scene1));

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(buttonlayout2);
        scene2 = new Scene(layout2);*/

    }

    public static Scene startScene() {
        start();
        return scene;
    }
}