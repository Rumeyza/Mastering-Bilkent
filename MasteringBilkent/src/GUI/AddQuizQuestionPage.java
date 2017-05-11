package GUI;

import ApplicationLogic.Course;
import ApplicationLogic.Question;
import ApplicationLogic.Quiz;
import ApplicationLogic.User;
import Storage.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by Asus on 10.5.2017.
 */
public class AddQuizQuestionPage {

    static Scene scene;

    public static void start(Quiz quiz, Course course, User user, int asnNo){

        DatabaseManager dbms = new DatabaseManager();

        BorderPane border = new BorderPane();
        border.setStyle("-fx-background: #FFFFFF;");
        VBox centerMenu = new VBox();
        centerMenu.setStyle("-fx-background: #FFFFFF;");
        centerMenu.setPadding(new Insets(10));
        centerMenu.setSpacing(8);
        centerMenu.setAlignment(Pos.TOP_CENTER);

        String fontFamily = "Helvetica";
        double titleFontSize = 48;

        Text scenetitle1 = new Text("MASTERING");
        scenetitle1.setFill(Color.BLUE);
        scenetitle1.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));

        Text scenetitle2 = new Text(" BILKENT");
        scenetitle2.setFill(Color.RED);
        scenetitle2.setFont(Font.font(fontFamily, FontWeight.EXTRA_BOLD, titleFontSize));

        HBox logo = new HBox();
        logo.setPadding(new Insets(10));
        logo.setSpacing(8);
        logo.setAlignment(Pos.TOP_CENTER);
        logo.getChildren().addAll(scenetitle1, scenetitle2);

        centerMenu.getChildren().addAll(logo);
        border.setTop(centerMenu);

        //Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(30);
        grid.setVgap(30);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background: #FFFFFF;");

        //questionText
        Label questionText = new Label("Enter Question Text:");
        grid.add(questionText, 0, 1);
        TextField questionTextTextField = new TextField();
        questionTextTextField.setPrefWidth(10);
        grid.add(questionTextTextField, 1, 1);

        //choice 1
        Label c1 = new Label("Enter First Choice:");
        grid.add(c1, 0, 2);
        TextField c1TextField = new TextField();
        grid.add(c1TextField, 1, 2);

        //choice 2
        Label c2 = new Label("Enter Second Choice:");
        grid.add(c2, 0, 3);
        TextField c2TextField = new TextField();
        grid.add(c2TextField, 1, 3);

        //choice 3
        Label c3 = new Label("Enter Third Choice:");
        grid.add(c3, 0, 4);
        TextField c3TextField = new TextField();
        grid.add(c3TextField, 1, 4);

        //choice 4
        Label c4 = new Label("Enter Fourth Choice:");
        grid.add(c4, 0, 5);
        TextField c4TextField = new TextField();
        grid.add(c4TextField, 1, 5);

        //choice 5
        Label c5 = new Label("Enter Fifth Choice:");
        grid.add(c5, 0, 6);
        TextField c5TextField = new TextField();
        grid.add(c5TextField, 1, 6);

        //Answer
        Label answer = new Label("Enter Answer:");
        grid.add(answer, 0, 7);
        TextField answerTextField = new TextField();
        grid.add(answerTextField, 1, 7);


        if( asnNo == quiz.getSize() ){

            Button addQuestionButton = new Button("Add Question");
            grid.add( addQuestionButton, 1,8);

            addQuestionButton.setOnAction((event)->{

                String qName, c11, c22, c33, c44, c55, ansans;
                int error = 1;
                qName = questionTextTextField.getText();
                if(qName.equals("")){
                    questionText.setTextFill(Color.RED);
                    questionTextTextField.setPromptText("Enter Question Text:");
                    error = -1;
                }
                c11 = c1TextField.getText();
                if(c11.equals("")){
                    c1.setTextFill(Color.RED);
                    c1TextField.setPromptText("Enter First Choice");
                    error = -1;
                }
                c22 = c2TextField.getText();
                if(c22.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Second Choice");
                    error = -1;
                }
                c33 = c2TextField.getText();
                if(c33.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Third Choice");
                    error = -1;
                }
                c44 = c2TextField.getText();
                if(c44.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Fourth Choice");
                    error = -1;
                }
                c55 = c2TextField.getText();
                if(c55.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Fifth Choice");
                    error = -1;
                }
                ansans = c2TextField.getText();
                if(ansans.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Answer");
                    error = -1;
                }
                if(error==-1)
                    return;
                else{
                    String[] ansArr = {c11, c22, c33, c44, c55};
                    Question question = new Question(qName, ansArr, ansans);
                    try {
                        dbms.insertToQuestion(quiz.getContentName(), quiz.getDescription(),qName,c11, c22, c33, c44, c55, ansans);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                LoginApp.myStage.setScene(CoursePage.startScene(course, user));
            });
        }
        else{
            asnNo++;
            Button addQuestionButton = new Button("Add New Question");
            grid.add( addQuestionButton, 1,8);

            addQuestionButton.setOnAction((event)->{

                String qName, c11, c22, c33, c44, c55, ansans;
                int error = 1;
                qName = questionTextTextField.getText();
                if(qName.equals("")){
                    questionText.setTextFill(Color.RED);
                    questionTextTextField.setPromptText("Enter Question Text:");
                    error = -1;
                }
                c11 = c1TextField.getText();
                if(c11.equals("")){
                    c1.setTextFill(Color.RED);
                    c1TextField.setPromptText("Enter First Choice");
                    error = -1;
                }
                c22 = c2TextField.getText();
                if(c22.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Second Choice");
                    error = -1;
                }
                c33 = c2TextField.getText();
                if(c33.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Third Choice");
                    error = -1;
                }
                c44 = c2TextField.getText();
                if(c44.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Fourth Choice");
                    error = -1;
                }
                c55 = c2TextField.getText();
                if(c55.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Fifth Choice");
                    error = -1;
                }
                ansans = c2TextField.getText();
                if(ansans.equals("")){
                    c2.setTextFill(Color.RED);
                    c2TextField.setPromptText("Enter Answer");
                    error = -1;
                }
                if(error==-1)
                    return;
                else{
                    String[] ansArr = {c11, c22, c33, c44, c55};
                    Question question = new Question(qName, ansArr, ansans);
                    try {
                        dbms.insertToQuestion(quiz.getContentName(), quiz.getDescription(),qName,c11, c22, c33, c44, c55, ansans);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                LoginApp.myStage.setScene(AddQuizQuestionPage.startScene(quiz, course, user));
            });


        }

        Hyperlink backHyper = new Hyperlink("Return to Course Page");
        grid.add(backHyper, 1, 9);
        backHyper.setOnAction(e-> {
            LoginApp.myStage.setScene(CoursePage.startScene(course, user));
            LoginApp.myStage.setTitle(course.getContentName());
        });

        border.setCenter(grid);
        scene = new Scene(border);
    }

    public static Scene startScene(Quiz quiz, Course course, User user) {
        start(quiz, course, user, 1);
        return scene;
    }
}
