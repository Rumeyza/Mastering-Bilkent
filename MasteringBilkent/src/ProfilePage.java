
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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

        Hyperlink returnlink = new Hyperlink("return");
        returnlink.setOnAction(e -> {
        	LoginApp.myStage.setScene(HomePage.startScene(userIndex));
        	LoginApp.myStage.setTitle("Home Page");
        });
        GridPane.setConstraints(returnlink, 0,7);

        infogrid.getChildren().addAll(text1, text2, text3, text4, returnlink);

        layout.getChildren().addAll(iv1, infogrid);

        scene = new Scene(layout);
    }

    public static Scene startScene(int index) {
        start(index);
        return scene;
    }
}
