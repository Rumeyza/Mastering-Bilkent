package GUI;

import ApplicationLogic.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.PasswordField;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;
import javafx.stage.Screen;
import javafx.stage.Stage;

import Storage.DatabaseManager;
import ApplicationLogic.Instructor;
import ApplicationLogic.Student;
public class LoginApp  extends Application {

    static Scene scene;
    static Stage myStage;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	DatabaseManager dbms = new DatabaseManager();
    	primaryStage.setTitle("Mastering Bilkent");

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");

        //Title
        String fontFamily = "Helvetica";
        double titleFontSize = 48;
        TextFlow textFlow = new TextFlow();
        Text scenetitle1 = new Text("MASTERING");
        scenetitle1.setFill(Color.BLUE);
        scenetitle1.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));
        Text scenetitle2 = new Text(" BILKENT");
        scenetitle2.setFill(Color.RED);
        scenetitle2.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));
        textFlow.getChildren().addAll(scenetitle1, scenetitle2);
        textFlow.setStyle("-fx-padding: 0, 10, 0, 10");
        grid.add(textFlow, 0, 0,2,1);

        Label userName = new Label("E-mail:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        userTextField.setPromptText("Enter E-mail");
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password  :");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        pwBox.setPromptText("**********");
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        Hyperlink registerHyper = new Hyperlink("Register Now!");
        TextFlow registerText = new TextFlow(new Text("\t\t\tDon't have an account? "),registerHyper);
        grid.add(registerText, 1, 6);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        registerHyper.setOnAction(e-> {
            primaryStage.setScene(RegisterPage.startScene());
            primaryStage.setTitle("Register now!");
        });

        btn.setOnAction(e -> {
        	
        	
        	try {
				Student studentLogin;
				studentLogin = dbms.getStudent(userTextField.getText(),pwBox.getText());
				Instructor instructorLogin;
				instructorLogin = dbms.getInstructor(userTextField.getText(),pwBox.getText());
				
				if(studentLogin != null && instructorLogin == null){
					System.out.println(studentLogin.getUserSurname());
					userTextField.setStyle("-fx-text-inner-color: black;");     
                    //	userTextField.setText("");
                    pwBox.setText("");
                    userName.setTextFill(Color.BLACK);
                    pw.setTextFill(Color.BLACK);
                    primaryStage.setScene(HomePage.startScene(studentLogin));
                    primaryStage.setTitle("Homepage");
				}
				else if( studentLogin == null && instructorLogin != null){
					userTextField.setStyle("-fx-text-inner-color: black;");     
                    //	userTextField.setText("");
                    pwBox.setText("");
                    userName.setTextFill(Color.BLACK);
                    pw.setTextFill(Color.BLACK);
                    primaryStage.setScene(InstructorHomePage.startScene(instructorLogin));
                    primaryStage.setTitle("Homepage");
				}
				else{
                	userName.setTextFill(Color.RED);
                	pw.setTextFill(Color.RED);
				}

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	
        	/*User result = Main.findUser( userTextField.getText(),pwBox.getText());
                    if(result!= null){
                    	userTextField.setStyle("-fx-text-inner-color: black;");     
                    //	userTextField.setText("");
                    	pwBox.setText("");
                    	userName.setTextFill(Color.BLACK);
                    	pw.setTextFill(Color.BLACK);
                    	if(result.getUserRole().equals("an Instructor"))
                    		 primaryStage.setScene(InstructorHomePage.startScene(result));
                    	else
                    		primaryStage.setScene(HomePage.startScene(result));
                        primaryStage.setTitle("Homepage");
                        
                    }
                    else{
                    	userName.setTextFill(Color.RED);
                    	pw.setTextFill(Color.RED);
                    }*/

           }
        );
        
        Screen screen1 = Screen.getPrimary();
        Rectangle2D bounds = screen1.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        scene = new Scene(grid);
        primaryStage.setScene(scene);
        myStage = primaryStage;
        myStage.show();

    }
    public static void method(String[] args) {
        launch(args);
    }
}
    
