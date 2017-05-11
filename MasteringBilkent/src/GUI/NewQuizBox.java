package GUI;

import ApplicationLogic.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Asus on 10.5.2017.
 */
public class NewQuizBox {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static void display( Instructor inst, Course course ){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New Course");
        window.setWidth(600);
        window.setHeight(400);

        //New Quiz Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");

        //Quiz Name
        Label quizName = new Label("Enter Quiz Name:");
        grid.add(quizName, 0, 1);
        TextField quizNameTextField = new TextField();
        quizNameTextField.setPrefWidth(10);
        grid.add(quizNameTextField, 1, 1, 8, 1);

        //Quiz Size
        Label quizSize = new Label("Enter Number of Questions:");
        grid.add(quizSize, 0, 2);
        TextField quizSizeTextField = new TextField();
        grid.add(quizSizeTextField, 1, 2 ,8 ,1);

        //Quiz description
        Label quizDesc = new Label("Enter Quiz Description:");
        grid.add(quizDesc, 0, 3);
        TextField quizDescTextField = new TextField();
        grid.add(quizDescTextField, 1, 3 ,8 ,1);


        //Quiz Graded check
        CheckBox checkbox = new CheckBox("Is the quiz graded?");
        checkbox.setSelected(false);
        grid.add(checkbox, 0,4);

        Button create = new Button("Add Quiz");
        grid.add(create, 4,4);

        create.setOnAction((event)->{

            String qName, qSize, qDesc;
            int error = 1;
            qName = quizNameTextField.getText();
            if(qName.equals("")){
                quizName.setTextFill(Color.RED);
                quizNameTextField.setPromptText("Please Enter a Name");
                error = -1;
            }
            qSize = quizSizeTextField.getText();
            if(!isInteger(qSize)){
                quizSize.setTextFill(Color.RED);
                quizSizeTextField.setPromptText("Please Enter Question Number");
                error = -1;
            }
            qDesc = quizDescTextField.getText();
            if(qDesc.equals("")){
                quizDesc.setTextFill(Color.RED);
                quizDescTextField.setPromptText("Please Enter a Short Description");
                error = -1;
            }
            if(error==-1)
                return;

            else{
                boolean check = checkbox.isSelected();
                int qSizeInt = Integer.parseInt(qSize);
                try {
                    inst.createQuiz( qName, qSizeInt, qDesc,!check);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Quiz quiz = new Quiz(qName,qSizeInt,qDesc,!check);
                LoginApp.myStage.setScene(AddQuizQuestionPage.startScene(quiz, course, inst));
                window.close();
                return;
            }

        });
        grid.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.showAndWait();

    }


}
