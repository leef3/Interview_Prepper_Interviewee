package studios.redleef.interviewprepperinterviewee.DataModels;

/**
 * Created by Fred Lee on 9/27/2015.
 */
public class Question {

    private String questionText, answerText;
    private boolean answered, favorited;

    public Question(String questionText)
    {
        this.questionText = questionText;
        boolean answered = false;
        boolean favorited = false;
    }

    public void SetAnswer(String answerText)
    {
        this.answerText = answerText;
        answered = true;
    }

    public void SetFavorite(boolean toSet)
    {
       favorited = toSet;
    }

    public String GetQuestion() { return questionText; }
    public String GetAnswer() { return answerText; }
    public boolean GetFavorited() { return favorited; }
    public boolean GetAnswered() { return answered; }
}
