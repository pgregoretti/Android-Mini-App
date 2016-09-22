package awz4pc.cs2110.virginia.edu.androidproject;

public class Answer implements QuizEntity{
    String answerText;
    public int category;

    public Answer(String answerText, int category) {
        this.answerText = answerText;
        this.category = category;
    }

    public String getText()
    {
        return answerText;
    }
}
