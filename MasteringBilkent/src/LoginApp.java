import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
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
 

public class LoginApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MASTERING BILKENT");
        GridPane grid = new GridPane();
        
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");

        
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

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
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
        registerHyper.setOnAction(e->RegisterPage.start());
        
      /*  btn.setOnAction(e -> {
        	if(userTextField.getText().equals("rumeyza"))
        		RegisterPage.start();}
        );*/
        
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        
        Screen screenscreen = Screen.getPrimary();
        Rectangle2D bounds = screenscreen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        primaryStage.show();
    }
}
    