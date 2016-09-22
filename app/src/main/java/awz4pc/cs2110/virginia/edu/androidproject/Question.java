package awz4pc.cs2110.virginia.edu.androidproject;

public class Question {
    String questionText;
    Answer answers[];
    int type;

    public Question(String questionText, Answer answers[], int type) {
        this.questionText = questionText;
        this.answers = answers;
        this.type = type;
    }

    public QuizEntity[] getAnswers()
    {
        return answers;
    }

    public String getText()
    {
        return questionText;
    }
}
