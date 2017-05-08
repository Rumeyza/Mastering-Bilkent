package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import ApplicationLogic.User;
/**
 * Created by Asus on 1.5.2017.
 */
public class CoursePage {

    static Scene scene;

    public static void start(int userIndex){


        //  BORDER PANE COMPONENTS
        //  CENTER
        VBox centerMenu = new VBox();
        centerMenu.setPadding(new Insets(10));
        centerMenu.setSpacing(8);
        centerMenu.setAlignment(Pos.TOP_CENTER);

        //Mastering Bilkent Title
        String fontFamily = "Helvetica";
        double titleFontSize = 36;

        Text scenetitle1 = new Text("ApplicationLogic.Course Page");
        scenetitle1.setFill(Color.rgb(46, 113, 129));
        scenetitle1.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));

        HBox logo = new HBox();
        logo.setPadding(new Insets(10));
        logo.setSpacing(8);
        logo.setAlignment(Pos.TOP_CENTER);
        logo.getChildren().addAll(scenetitle1);

        //Line
        Line line = new Line(0, 20, 750, 20);

        Hyperlink buttonA = new Hyperlink("Register Another ApplicationLogic.Course");

        centerMenu.getChildren().addAll(logo,line, buttonA);
        //  CENTER END

        //  LEFT
        VBox leftMenu = new VBox();
        leftMenu.setStyle("-fx-background-color: #4198AE;");
        leftMenu.setPadding(new Insets(10));
        leftMenu.setSpacing(8);

        //profile image
        GridPane imagegrid = new GridPane();
        Image avatar = new Image("file:bilkent.png");
        ImageView iv1 = new ImageView();
        iv1.setFitWidth(240);
        iv1.setFitHeight(240);
        iv1.setImage(avatar);
        imagegrid.add(iv1,0,0);
        imagegrid.setAlignment(Pos.CENTER);

        //user information grid
        GridPane infogrid = new GridPane();
        infogrid.setPadding(new Insets(10,10,10,10));
        infogrid.setVgap(8);
        infogrid.setHgap(10);

        String fontFamily1 = "Helvetica";
        double titleFontSize1 = 16;

        User user = Main.arr.get(userIndex);

        Text userName = new Text(10, 20, user.getUserName() + " " + user.getUserSurname());
        userName.setFont(Font.font(fontFamily1, titleFontSize1));
        userName.setFill(Color.WHITE);

        Text userInst = new Text(10, 20, user.getUserInstitution());
        userInst.setFont(Font.font(fontFamily1, titleFontSize1));
        userInst.setFill(Color.WHITE);
        GridPane.setConstraints(userInst, 0,1,2,1);

        Text userDep = new Text(10, 20,  user.getUserDepartment()+ " / " + user.getUserTitle());
        userDep.setFont(Font.font(fontFamily1, titleFontSize1));
        userDep.setFill(Color.WHITE);
        GridPane.setConstraints(userDep, 0,2);

        Text userEmail = new Text(10, 20, user.getUserEmail());
        userEmail.setFont(Font.font(fontFamily1, titleFontSize1));
        userEmail.setFill(Color.WHITE);
        GridPane.setConstraints(userEmail, 0,3,3,3);

        Line line2 = new Line(0,0, 200, 0);
        line2.setStyle("-fx-stroke: #FFFFFF;");
        GridPane.setConstraints(line2, 0,6);

        infogrid.getChildren().addAll(userName, userInst, userDep, userEmail, line2);


        //NAVİGATOR LİST

        Hyperlink link1 = new Hyperlink("Home Page");
        link1.setStyle("-fx-text-fill: white");
        link1.setOnAction(e -> {
            if(Main.arr.get(userIndex).getUserRole().equals("an ApplicationLogic.Instructor"))
                LoginApp.myStage.setScene(InstructorHomePage.startScene(userIndex));
            else
                LoginApp.myStage.setScene(HomePage.startScene(userIndex));

            LoginApp.myStage.setTitle("Mastering Bilkent");//---------------------------------> her classın başına koyalım
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
        searchfield.setPromptText("Find ApplicationLogic.Course");
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

    public static Scene startScene(int index) {
        start(index);
        return scene;
    }
}
