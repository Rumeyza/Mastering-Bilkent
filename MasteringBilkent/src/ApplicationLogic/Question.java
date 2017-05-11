package ApplicationLogic;

import java.util.Arrays;

/**
 * Created by Asus on 7.5.2017.
 */
public class Question {

    private String questionText;
    private String answer;

    public Question(String questionText, String[] choiseList, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
