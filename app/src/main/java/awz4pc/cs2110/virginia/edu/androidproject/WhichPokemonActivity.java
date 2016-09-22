package awz4pc.cs2110.virginia.edu.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class WhichPokemonActivity extends AppCompatActivity {
    int[] icons = new int[6];
    TextView questionText;
    PokemonQuiz pokemonQuiz;
    ArrayList<Question> questionList;
    Question q;
    Answer a1;
    Answer a2;
    Answer a3;
    Answer a4;
    Button choice1;
    Button choice2;
    Button choice3;
    Button choice4;
    int numQuestions;
    int currentQuestion;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    String pokemonResult;

    //private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    //private int mProgressStatus = 0;

    //private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_which_pokemon);
        questionText = (TextView)findViewById(R.id.WPQuestion);
        pokemonQuiz = new PokemonQuiz();
        //Intent intent = getIntent();
        //myersResult = intent.getStringExtra(MainActivity.MYERS_MESSAGE);
        //myersBriggsQuiz = intent.getSerializableExtra("Myers");
        questionList = pokemonQuiz.getQuestions();
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);
        choice3 = (Button) findViewById(R.id.choice3);
        choice4 = (Button) findViewById(R.id.choice4);

        mProgress = (ProgressBar) findViewById(R.id.progressBar);


        // populate with question and answer text
        setQuestionView();
    }



    private void setQuestionView() {
        questionText.setText(questionList.get(0).questionText);
        choice1.setText(questionList.get(0).answers[0].answerText);
        choice2.setText(questionList.get(0).answers[1].answerText);
        choice3.setText(questionList.get(0).answers[2].answerText);
        choice4.setText(questionList.get(0).answers[3].answerText);
        numQuestions = questionList.size();
        currentQuestion = 0;
    }

    public void updateQuestionChoice(View view){

        //update question or go to results page
        if(currentQuestion<numQuestions-1){

            // make things more readable
            // and update response
            q = questionList.get(currentQuestion);
            a1 = questionList.get(currentQuestion).answers[0];
            a2 = questionList.get(currentQuestion).answers[1];
            a3 = questionList.get(currentQuestion).answers[2];
            a4 = questionList.get(currentQuestion).answers[3];

            if(view == choice1){
                pokemonQuiz.recordResponse(q,a1);
            }
            if(view == choice2){
                pokemonQuiz.recordResponse(q,a2);
            }
            if(view == choice3){
                pokemonQuiz.recordResponse(q,a3);
            }
            if(view == choice4){
                pokemonQuiz.recordResponse(q,a4);
            }


            // update to next question
            currentQuestion++;
            q = questionList.get(currentQuestion);
            a1 = questionList.get(currentQuestion).answers[0];
            a2 = questionList.get(currentQuestion).answers[1];
            a3 = questionList.get(currentQuestion).answers[2];
            a4 = questionList.get(currentQuestion).answers[3];
            questionText.setText(q.questionText);
            choice1.setText(a1.answerText);
            choice2.setText(a2.answerText);
            choice3.setText(a3.answerText);
            choice4.setText(a4.answerText);

            mProgress.incrementProgressBy(1);
        } else {
            Intent intent = new Intent(this, WhichPokemonResultsActivity.class);
            pokemonResult = pokemonQuiz.getResult();
            intent.putExtra(EXTRA_MESSAGE, pokemonResult);
            startActivity(intent);
            finish();
        }
    }

}
