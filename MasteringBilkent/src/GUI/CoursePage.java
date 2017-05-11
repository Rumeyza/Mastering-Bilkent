package GUI;

import ApplicationLogic.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import Storage.DatabaseManager;

import java.util.ArrayList;

public class CoursePage {

    static Scene scene;

    public static void start(Course course, User user){

        ScrollPane sp = new ScrollPane();

    	Instructor courseCreator = new Instructor();
    	int userId = -1;
    	DatabaseManager dbms = new DatabaseManager();
    	try {
			 userId = dbms.getInstructorId(user.getUserEmail(), user.getUserPassword());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	try {
    		courseCreator = dbms.getInstructor(course.getInstructorId());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        //  BORDER PANE COMPONENTS
        //  CENTER
        VBox centerMenu = new VBox();
        centerMenu.setPadding(new Insets(10));
        centerMenu.setSpacing(8);
        centerMenu.setAlignment(Pos.TOP_CENTER);

        //Mastering Bilkent Title
        String fontFamily = "Helvetica";
        double titleFontSize = 36;

        Text scenetitle1 = new Text("Mastering Bilkent Course Page");
        scenetitle1.setFill(Color.rgb(46, 113, 129));
        scenetitle1.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));

        HBox logo = new HBox();
        logo.setPadding(new Insets(10));
        logo.setSpacing(8);
        logo.setAlignment(Pos.TOP_CENTER);
        logo.getChildren().addAll(scenetitle1);

        //Line
        Line line = new Line(0, 20, 750, 20);
        //Line ends

        //Intructor Course List
        /*
        ArrayList<Content> list = null;

        for(int i = 0 ; i < list.size();i++){
            Course course = list.get(i);

            VBox courseBox = new VBox();
            courseBox.setPadding(new Insets(15));
            courseBox.setSpacing(10);
            courseBox.setAlignment(Pos.TOP_CENTER);
            courseBox.setStyle("-fx-background-color:  #003366");

            Hyperlink courseLink = new Hyperlink(c.getContentName());
            int id = list.get(i).getContentId();
            courseLink.setOnAction(e -> LoginApp.myStage.setScene(CoursePage.startScene(course, instructor)));
            courseLink.setStyle("-fx-text-fill: white");
            courseLink.setFont(Font.font("Helvetica", 24));
            courseLink.setBorder(Border.EMPTY);
            Instructor courseCreator = new Instructor();
            try {
                courseCreator = dbms.getInstructor(course.getInstructorId());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            Text ins = new Text(courseCreator.getUserName()+" / Spring 2017");
            ins.setFill(Color.WHITE);
            ins.setFont(Font.font("Helvetica",18));
            courseBox.getChildren().addAll(courseLink, ins);
            centerMenu.getChildren().addAll(courseBox);

        }

        sp.setFitToHeight(true);
        sp.setVmax(1000);
        sp.setPrefSize(115, 150);
        sp.setContent(centerMenu);
*/
        //Instructor Course List End

        if(userId == course.getInstructorId()){
        	Hyperlink selection = new Hyperlink("Add Content");
        	selection.setOnAction(e-> ContentSelectionBox.display(course, user));
        	centerMenu.getChildren().addAll(logo,line, selection);
        }
        else if(user.getUserRole().equals("student")){
        	boolean isExist = false; 
        	try {
				isExist = dbms.isEnrolled(course.getContentName(), user.getUserName());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	if(isExist){
        		Hyperlink register = new Hyperlink("Register This Course");
            	register.setOnAction(e-> {
    				try {
    					user.enrollCourse(course.getContentName());
    				} catch (Exception e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
    			});
            	centerMenu.getChildren().addAll(logo,line, register);
        	}
        	else{
        		centerMenu.getChildren().addAll(logo,line);
        	}
        	
        } else centerMenu.getChildren().addAll(logo,line);

        //  CENTER END

        //  LEFT
        VBox leftMenu = new VBox();
        leftMenu.setStyle("-fx-background-color: #003366;");
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


        Text courseName = new Text(10, 20, courseCreator.getUserName());
        courseName.setFont(Font.font(fontFamily1, titleFontSize1));
        courseName.setFill(Color.WHITE);
        GridPane.setConstraints(courseName, 0,3,2,1);

        Text courseInst = new Text(10, 20, course.getContentName());
        courseInst.setFont(Font.font(fontFamily1, titleFontSize1));
        courseInst.setFill(Color.WHITE);
        GridPane.setConstraints(courseInst, 0,1,2,1);

        infogrid.getChildren().addAll(courseName, courseInst);

        //NAVİGATOR LİST
        //comment

        Hyperlink link1 = new Hyperlink("Return");
        link1.setStyle("-fx-text-fill: white");
        link1.setOnAction(e -> {
            if(user.getUserRole().equals("instructor"))
                LoginApp.myStage.setScene(Offerings.startScene(user));
            else if(user.getUserRole().equals("student"))
                 LoginApp.myStage.setScene(Offerings.startScene(user));
            LoginApp.myStage.setTitle("Mastering Bilkent");//---------------------------------> her classın başına koyalım
        });

        Hyperlink link2 = new Hyperlink("My Courses");
        link2.setStyle("-fx-text-fill: white");
        if(user.getUserRole().equals("student"))
            link2.setOnAction(e -> LoginApp.myStage.setScene(HomePage.startScene(user)) );
        else if(user.getUserRole().equals("instructor"))
            link2.setOnAction(e -> LoginApp.myStage.setScene(InstructorHomePage.startScene(user)) );

        Hyperlink link3 = new Hyperlink("Profile");
        link3.setStyle("-fx-text-fill: white");
        link3.setOnAction(e -> {
            LoginApp.myStage.setScene(ProfilePage.startScene(user));
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

    public static Scene startScene(Course course, User user) {
        start(course, user);
        return scene;
    }
}
