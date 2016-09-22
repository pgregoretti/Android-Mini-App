package awz4pc.cs2110.virginia.edu.androidproject;


import java.util.List;

public interface Quiz
{
    String getName();
    String getResult();
    void recordResponse(Question q, QuizEntity a);
    void resetResults();
    List<Question> getQuestions();
}
