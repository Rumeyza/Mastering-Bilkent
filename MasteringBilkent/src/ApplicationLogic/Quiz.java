package ApplicationLogic;



/**
 * Created by Asus on 7.5.2017.
 */
public class Quiz extends Content{

    private int size;
    private String description;
    private boolean graded;

    public Quiz() {
        super( "Default ApplicationLogic.Quiz");
        this.size = 1;
        this.description = "This is an example quiz of size of one question.";
        this.graded = false;
    }


    public Quiz(String contentName, int size, String description, boolean graded) {
        super(contentName);
        this.size = size;
        this.description = description;
        this.graded = graded;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isGraded() {
        return graded;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

/*
    public void addQuestion(String questionText, String[] choiceList, String answer){
        Question q = new Question(questionText, choiceList, answer);
        questionsList.add(q);
    }

    public void deleteQuestion(int questionNum){
        questionsList.remove(questionNum);
    }

    public void returnQuestion(int questionNum){
        questionsList.get(questionNum);
    }

*/
}
