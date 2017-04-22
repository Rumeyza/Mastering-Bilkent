
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class ProfilePage {

    static Scene scene;

    public static void start(int userIndex) {

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);

        GridPane infogrid = new GridPane();
        infogrid.setAlignment(Pos.CENTER);
        infogrid.setPadding(new Insets(10,10,10,10));
        infogrid.setVgap(8);
        infogrid.setHgap(10);

        //profile image
        Image avatar = new Image("file:avatar.png");
        ImageView iv1 = new ImageView();
        iv1.setFitWidth(240);
        iv1.setFitHeight(240);
        iv1.setImage(avatar);
        GridPane.setConstraints(iv1, 0,0,1,3);

        String fontFamily1 = "Helvetica";
        double titleFontSize1 = 19;

        Text text1 = new Text(10, 20, Main.arr.get(userIndex).getUserName() + " " + Main.arr.get(userIndex).getUserSurname());
        text1.setFont(Font.font(fontFamily1, titleFontSize1));

        Text text2 = new Text(10, 20, Main.arr.get(userIndex).getUserInstitution());
        text2.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text2, 0,1,2,1);

        Text text3 = new Text(10, 20,  Main.arr.get(userIndex).getUserDepartment()+ " / " + Main.arr.get(userIndex).getUserTitle());
        text3.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text3, 0,2);

        Text text4 = new Text(10, 20, Main.arr.get(userIndex).getUserEmail());
        text4.setFont(Font.font(fontFamily1, titleFontSize1));
        GridPane.setConstraints(text4, 0,3,3,3);

        infogrid.getChildren().addAll(text1, text2, text3, text4);

        layout.getChildren().addAll(iv1, infogrid);

        
        //navigator list
        
        Line line = new Line(0,0, 200, 0);
        line .setStyle("-fx-stroke: #FFFFFF;");
        GridPane.setConstraints(line , 0,6);

        Hyperlink link1 = new Hyperlink("Home Page");
        link1.setStyle("-fx-text-fill: white");
        link1.setOnAction(e -> {
            LoginApp.myStage.setScene(HomePage.startScene(userIndex));
            LoginApp.myStage.setTitle("Home Page");
        });

        Hyperlink link2 = new Hyperlink("My Courses");
        link2.setStyle("-fx-text-fill: white");
        //link2.setOnAction(e -> );

        Hyperlink link3 = new Hyperlink("Profile");
        link3.setStyle("-fx-text-fill: white");
        link3.setOnAction(e -> {
            LoginApp.myStage.setScene(ProfilePage.startScene(userIndex));
            LoginApp.myStage.setTitle("Your Profile");
        });

        Hyperlink link4 = new Hyperlink("Send Feedback");
        link4.setStyle("-fx-text-fill: white");
        link4.setOnAction(e -> AlertBox.display("contact","mastering@bilkent.edu.tr"));

        Hyperlink link5 = new Hyperlink("Settings");
        link5.setStyle("-fx-text-fill: white");
        //link5.setOnAction(e -> );

        Hyperlink logoutlink = new Hyperlink("Logout");
        logoutlink.setStyle("-fx-text-fill: white");
        logoutlink.setOnAction(e -> {
            LoginApp.myStage.setScene(LoginApp.scene);
            LoginApp.myStage.setTitle("Mastering Bilkent");
        });

        //search bar
        final TextField searchfield = new TextField();
        searchfield.setPromptText("Find Course");
        searchfield.setPrefColumnCount(10);
        searchfield.getText();

        VBox leftMenu = new VBox();
        leftMenu.setStyle("-fx-background-color: #4198AE;");
        leftMenu.setPadding(new Insets(10));
        leftMenu.setSpacing(8);

        leftMenu.getChildren().addAll(line, link1, link2, link3, link4, link5,logoutlink, searchfield);
        leftMenu.setAlignment(Pos.CENTER_LEFT);

        //  LEFT END

        BorderPane layout1 = new BorderPane();
        layout1.setCenter(layout);
        layout1.setLeft(leftMenu);
        layout1.setStyle("-fx-background: #FFFFFF;");

        scene = new Scene(layout1);
    }

    public static Scene startScene(int index) {
        start(index);
        return scene;
    }
}
