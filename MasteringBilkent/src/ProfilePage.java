import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class ProfilePage {

    static Scene scene;

    public static void start() {
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

        Hyperlink returnlink = new Hyperlink("return");
        returnlink.setOnAction(e -> {
            LoginApp.outStage.setScene(HomePage.startScene());
            LoginApp.outStage.setTitle("Home Page");
        });
        GridPane.setConstraints(returnlink, 0,7);

        infogrid.getChildren().addAll(iv1, text2, text3, text4, text5, text6, returnlink);
        infogrid.setAlignment(Pos.CENTER);


        scene = new Scene(infogrid);
    }

    public static Scene startScene() {
        start();
        return scene;
    }
}
