import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Text;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.control.PasswordField;
import javafx.scene.text.FontWeight;

import javafx.scene.text.Font;

import javafx.scene.text.TextFlow;
 
public class RegisterPage {
 /*   public static void main(String[] args) {
        launch(args);
    }*/
    public static void start() {
    	Stage primaryStage = new Stage();
    	//Stage
    	primaryStage.setTitle("Registration Page");
    
 
        
        
        //Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(100);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");
   

        Scene scene = new Scene(grid, 600, 500);
        primaryStage.setScene(scene);
        
        /*Text scenetitle = new Text("MASTERING BILKENT");
        scenetitle.setFont(Font.font("Halvetica", FontWeight.EXTRA_BOLD, 50));
        scenetitle.setFill( Color.BLUE);
        
        grid.add(scenetitle, 2, 0, 2, 1);*/
        
        String fontFamily = "Helvetica";
        double titleFontSize = 75;

        TextFlow textFlow = new TextFlow();
        
        Text scenetitle1 = new Text("MASTERING");
        scenetitle1.setFill(Color.BLUE);
        scenetitle1.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));
        Text scenetitle2 = new Text(" BILKENT");
        scenetitle2.setFill(Color.RED);
        scenetitle2.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));
        
        textFlow.getChildren().addAll(scenetitle1, scenetitle2);
        
        grid.add(textFlow, 2, 0);

        //user name
        Label userName = new Label("Enter Your Name:");
        grid.add(userName, 0, 2);
        TextField userNameTextField = new TextField();
        grid.add(userNameTextField, 1, 2);
        
        //user surname
        Label userSurname = new Label("Enter Your Surname:");
        grid.add(userSurname, 0, 3);
        TextField userSurnameTextField = new TextField();
        grid.add(userSurnameTextField, 1, 3);
        
        //user email
        Label userEmail = new Label("Enter Your E-mail:");
        grid.add(userEmail, 0, 4);
        TextField userEmailTextField = new TextField();
        grid.add(userEmailTextField, 1, 4);
        
        //user choose password
        
        Label pw = new Label("Enter Your Password:");
        grid.add(pw, 0, 5);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 5);
        
        //user re enter password
        Label repw = new Label("Re-Enter Your Password:");
        grid.add(repw, 0, 6);
        PasswordField repwBox = new PasswordField();
        grid.add(repwBox, 1, 6);
        
        //user department
        Label userDepartment = new Label("Institution:");
        grid.add(userDepartment, 0, 7);
        TextField userDepartmentTextField = new TextField();
        grid.add(userDepartmentTextField, 1, 7);
        
        //user address

        
        //Button and Text
        
        /*Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 8);*/
        
        
        
        
        
        
        
        
        
        
        
        
        
    	
    	
    	
    	/*GridPane grid = new GridPane();
    	grid.setAlignment(Pos.CENTER);
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(25, 25, 25, 25));
    	
    	Button button2 = new Button("Button 2");
    	button2.setStyle("-fx-background-color: #00ff00");
    	
    	
    	
    	Text scenetitle = new Text("Welcome");
    	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    	grid.add(scenetitle, 0, 0, 2, 1);

    	Label userName = new Label("User Name:");
    	grid.add(userName, 0, 1);

    	TextField userTextField = new TextField();
    	grid.add(userTextField, 1, 1);

    	Label pw = new Label("Password:");
    	grid.add(pw, 0, 2);

    	PasswordField pwBox = new PasswordField();
    	grid.add(pwBox, 1, 2);
    	primaryStage.setTitle("Registration Page");
    	
    	Button btn = new Button("Sign in");
    	HBox hbBtn = new HBox(10);
    	hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    	hbBtn.getChildren().add(btn);
    	grid.add(hbBtn, 1, 4);

        primaryStage.show();*/
       	Screen screenscreen = Screen.getPrimary();
        Rectangle2D bounds = screenscreen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.show();
    }
    
  /*  @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }*/
    
    
    
    /*@Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Button Experiment 1");

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");

        button1.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
        button2.setStyle("-fx-background-color: #00ff00");
        button3.setStyle("-fx-font-size: 2em; ");
        button4.setStyle("-fx-text-fill: #0000ff");


        HBox hbox = new HBox(button1, button2, button3, button4);


        Scene scene = new Scene(hbox, 400, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/
    
   }
    