package GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Created by Asus on 8.5.2017.
 */
public class VideoPage {
    public class Main extends Application {

        public void main(String[] args) { launch(args); }

        @Override
        public void start(Stage stage) throws Exception {

            WebView webview = new WebView();
            webview.getEngine().load("https://www.youtube.com/watch?v=5FPIcb5QVNw");
            webview.setPrefSize(1080, 720);

            stage.setScene(new Scene(webview));
            stage.show();
        }
    }
}
