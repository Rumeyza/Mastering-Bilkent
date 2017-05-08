package ApplicationLogic;

import java.util.Arrays;

/**
 * Created by Asus on 7.5.2017.
 */
public class Question { //asdfbkhgbhjbkhkbh

    private String questionText;
    private String[] choiseList;
    private String answer;

    public Question(String questionText, String[] choiseList, String answer) {
        this.questionText = questionText;
        this.choiseList = choiseList;
        this.answer = answer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String[] getChoiseList() {
        return choiseList;
    }

    public void setChoiseList(String[] choiseList) {
        this.choiseList = choiseList;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ApplicationLogic.Question{" +
                "questionText='" + questionText + '\'' +
                ", choiseList=" + Arrays.toString(choiseList) +
                ", answer='" + answer + '\'' +
                '}';
    }
}
