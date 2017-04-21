
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
import javafx.scene.shape.*;


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
        double titleFontSize = 36;

        Text scenetitle1 = new Text("Mastering Bilkent Student Home Page");
        scenetitle1.setFill(Color.rgb(46, 113, 129));
        scenetitle1.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));

        HBox logo = new HBox();
        logo.setPadding(new Insets(10));
        logo.setSpacing(8);
        logo.setAlignment(Pos.TOP_CENTER);
        logo.getChildren().addAll(scenetitle1);

        //Line
        Line line = new Line(0, 20, 750, 20);

        Hyperlink buttonA = new Hyperlink("Register Another Course");

        centerMenu.getChildren().addAll(logo,line, buttonA);
        //  CENTER END

        //  LEFT
        VBox leftMenu = new VBox();
        leftMenu.setStyle("-fx-background-color: #4198AE;");
        leftMenu.setPadding(new Insets(10));
        leftMenu.setSpacing(8);

        //profile image
        GridPane imagegrid = new GridPane();
        Image avatar = new Image("file:avatar.png");
        ImageView iv1 = new ImageView();
        iv1.setFitWidth(240);
        iv1.setFitHeight(300);
        iv1.setImage(avatar);
        imagegrid.add(iv1,0,0);
        imagegrid.setAlignment(Pos.CENTER);

        //user information grid
        GridPane infogrid = new GridPane();
        infogrid.setPadding(new Insets(10,10,10,10));
        infogrid.setVgap(8);
        infogrid.setHgap(10);

        String fontFamily1 = "Helvetica";
        double titleFontSize1 = 19;

        User ari = new User();
        Text username = new Text(10, 20, ari.getUserName() + " " + ari.getUserSurname());
        username.setFont(Font.font(fontFamily1, titleFontSize1));

        Text text3 = new Text(10, 20, "Bilkent University");
        text3.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text3, 0,1,2,1);

        Text text4 = new Text(10, 20, "CS /" + "Undergraduate");
        text4.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text4, 0,2);

        Text text6 = new Text(10, 20, "arif.bozdag@ug.bilkent.edu.tr");
        text6.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text6, 0,3,3,3);

        infogrid.getChildren().addAll(username, text3, text4, text6);

        //navigator list

        Hyperlink link1 = new Hyperlink("Main Page");
        link1.setStyle("-fx-text-fill: white;");
        //link1.setOnAction(e -> );

        Hyperlink link2 = new Hyperlink("My Courses");
        link2.setStyle("-fx-text-fill: white;");
        //link2.setOnAction(e -> );

        Hyperlink link3 = new Hyperlink("Profile");
        link3.setStyle("-fx-text-fill: white;");
        link3.setOnAction(e -> {
            LoginApp.outStage.setScene(ProfilePage.startScene());
            LoginApp.outStage.setTitle("Your Profile");
        });

        Hyperlink link4 = new Hyperlink("Send Feedback");
        link4.setStyle("-fx-text-fill: white;");
        link4.setOnAction(e -> AlertBox.display("contact","mastering@bilkent.edu.tr"));

        Hyperlink link5 = new Hyperlink("Settings");
        link5.setStyle("-fx-text-fill: white;");
        //link5.setOnAction(e -> );

        Hyperlink logoutlink = new Hyperlink("Logout");
        logoutlink.setStyle("-fx-text-fill: white;");
        logoutlink.setOnAction(e -> {
            LoginApp.outStage.setScene(LoginApp.startScene());
            LoginApp.outStage.setTitle("Mastering Bilkent");
        });

        //search bar
        final TextField searchfield = new TextField();
        searchfield.setPromptText("Find Course");
        searchfield.setPrefColumnCount(10);
        searchfield.getText();

        leftMenu.getChildren().addAll(imagegrid, infogrid, link1, link2, link3, link4, link5,logoutlink, searchfield);
        leftMenu.setAlignment(Pos.TOP_LEFT);

        //  LEFT END

        //  BORDER PANE
        BorderPane layout1 = new BorderPane();
        layout1.setCenter(centerMenu);
        layout1.setLeft(leftMenu);
        layout1.setStyle("-fx-background: #FFFFFF;");

        scene = new Scene(layout1);

    }

    public static Scene startScene() {
        start();
        return scene;
    }
}
