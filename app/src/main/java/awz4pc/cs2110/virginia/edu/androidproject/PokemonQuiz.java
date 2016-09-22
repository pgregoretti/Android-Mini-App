package awz4pc.cs2110.virginia.edu.androidproject;

import java.util.ArrayList;
import java.util.Arrays;

import awz4pc.cs2110.virginia.edu.androidproject.Answer;
import awz4pc.cs2110.virginia.edu.androidproject.MyersBriggsQuiz;
import awz4pc.cs2110.virginia.edu.androidproject.Question;
import awz4pc.cs2110.virginia.edu.androidproject.Quiz;
import awz4pc.cs2110.virginia.edu.androidproject.QuizEntity;

/**
 * Created by pamela on 9/19/16.
 */

public class PokemonQuiz implements Quiz {
    // Types for each question
    private static final int TYPE_EI = 0;
    private static final int TYPE_SN = 1;
    private static final int TYPE_TF = 2;
    private static final int TYPE_JP = 3;

    // Categories for each answer
    private static final int CORRECT = 1;
    private static final int INCORRECT = 0;

    private ArrayList<Question> questionList;
    public ArrayList<Question> getQuestions() {
        return this.questionList;
    }

    // Array for tracking quiz results
    private int[] results;

    public PokemonQuiz() {
        resetResults();

        // Init list of questions in the C constructor
        questionList = new ArrayList<Question>(Arrays.asList(
                new Question(
                        "Who is the mascot of Pokemon?",
                        new Answer[]{
                                new Answer("Bulbasaur", INCORRECT),
                                new Answer("Mew", INCORRECT),
                                new Answer("Pikachu", CORRECT),
                                new Answer("Missingno.", INCORRECT)
                        },
                        TYPE_EI
                ),
                new Question(
                        "Who created Pokemon?",
                        new Answer[]{
                                new Answer("Satoshi Tajiri", CORRECT),
                                new Answer("Junichi Masuda", INCORRECT),
                                new Answer("Tsunekazu Ishihara", INCORRECT),
                                new Answer("Notch", INCORRECT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "Who is the only Pokemon Ditto cannot breed with?",
                        new Answer[]{
                                new Answer("Luvdisc", INCORRECT),
                                new Answer("Wailord", INCORRECT),
                                new Answer("Darkrai", INCORRECT),
                                new Answer("Ditto", CORRECT)
                        },
                        TYPE_SN
                ),
                new Question(
                        "What are the odds of finding a shiny randomly?",
                        new Answer[]{
                                new Answer("1 in 512", INCORRECT),
                                new Answer("1 in 8192", CORRECT),
                                new Answer("1 in 4192", INCORRECT),
                                new Answer("1 in 1114", INCORRECT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "What are the 7th generation starter Pokemon named?",
                        new Answer[]{
                                new Answer("Leaflet, Shadflame, and Clonami", INCORRECT),
                                new Answer("Rowlet, Litten, and Popplio", CORRECT),
                                new Answer("Bladwing, Ashflame, and Clowsplash", INCORRECT),
                                new Answer("Tuxeflap, Tigfier, and Tsuclowni", INCORRECT)
                        },
                        TYPE_TF
                ),
                new Question(
                        "When was Pokemon Red and Blue released in the US?",
                        new Answer[]{
                                new Answer("February 27, 1996", INCORRECT),
                                new Answer("October 10, 1996", INCORRECT),
                                new Answer("September 28, 1998", CORRECT),
                                new Answer("September 12, 1998", INCORRECT)
                        },
                        TYPE_JP
                )
        ));
    }

    public String getName()
    {
        return "PokemonQuiz";
    }

    public String getResult()
    {
        if(results[0] >= 5){
            return "Pokemon master";
        } else {
            return "Pokemon novice";
        }
    }

    public void recordResponse(Question q, QuizEntity a)
    {
        Answer answer = (Answer)a;
        results[0] += answer.category;
    }

    public void resetResults()
    {
        // Reset the results to 0
        results = new int[3];
        for (int i = 0; i < results.length; i++) {
            results[i] = 0;
        }
    }

}
