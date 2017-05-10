package GUI;

import ApplicationLogic.Content;
import ApplicationLogic.Video;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Asus on 8.5.2017.
 */
public class VideoBox {

     public static void display(Video video){
         Stage window = new Stage();
         window.initModality(Modality.APPLICATION_MODAL);

         WebView webview = new WebView();
         webview.getEngine().load(video.getVideoUrl());
         webview.setPrefSize(1080, 720);

         window.setOnCloseRequest(e -> {
             webview.getEngine().load("");
         });

         window.setScene(new Scene(webview));
         window.showAndWait();

     }

}
