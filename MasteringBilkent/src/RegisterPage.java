
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.paint.Color;
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

    static Scene scene;

    public static void start() {

        //Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(100);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");

        //TITLE
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

        Hyperlink returnlink = new Hyperlink("return");
        returnlink.setOnAction(e -> {
            LoginApp.outStage.setScene(LoginApp.startScene());
            LoginApp.outStage.setTitle("Mastering Bilkent");
        });
        grid.add(returnlink,1,8);


        scene = new Scene(grid);
    }

    public static Scene startScene() {
        start();
        return scene;
    }
}
    