package awz4pc.cs2110.virginia.edu.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;


public class MyersBriggsActivity extends AppCompatActivity {
    TextView questionText;
    MyersBriggsQuiz myersBriggsQuiz;
    ArrayList<Question> questionList;
    Question q;
    Answer a1;
    Answer a2;
    Button choice1;
    Button choice2;
    int numQuestions;
    int currentQuestion;
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    String myersResult;

    //private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    //private int mProgressStatus = 0;

    //private Handler mHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myers_briggs);
        questionText = (TextView)findViewById(R.id.MBQuestion);
        myersBriggsQuiz = new MyersBriggsQuiz();
        Intent intent = getIntent();
        myersResult = intent.getStringExtra(MainActivity.MYERS_MESSAGE);
        //myersBriggsQuiz = intent.getSerializableExtra("Myers");
        questionList = myersBriggsQuiz.getQuestions();
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);

        mProgress = (ProgressBar) findViewById(R.id.progressBar);


        // populate with question and answer text
        setQuestionView();
    }



    private void setQuestionView() {
        questionText.setText(questionList.get(0).questionText);
        choice1.setText(questionList.get(0).answers[0].answerText);
        choice2.setText(questionList.get(0).answers[1].answerText);
        numQuestions = questionList.size();
        currentQuestion = 0;

    }

    public void exitResults(View view) {
        finish();
    }

    public void updateQuestionChoice1(View view){

        //update question or go to results page
        if(currentQuestion<numQuestions-1){

            // make things more readable
            // and update response
            q = questionList.get(currentQuestion);
            a1 = questionList.get(currentQuestion).answers[0];
            a2 = questionList.get(currentQuestion).answers[1];
            myersBriggsQuiz.recordResponse(q, a1);

            // update to next question
            currentQuestion++;
            q = questionList.get(currentQuestion);
            a1 = questionList.get(currentQuestion).answers[0];
            a2 = questionList.get(currentQuestion).answers[1];
            questionText.setText(q.questionText);
            choice1.setText(a1.answerText);
            choice2.setText(a2.answerText);

            mProgress.incrementProgressBy(1);
        } else {
            Intent intent = new Intent(this, MyersBriggsResultsActivity.class);
            myersResult = myersBriggsQuiz.getResult();
            intent.putExtra(EXTRA_MESSAGE, myersResult);
            startActivity(intent);
            finish();
        }
    }

    public void updateQuestionChoice2(View view){

        //update question or go to results page
        if(currentQuestion<numQuestions-1){

            // make things more readable
            // and update response
            q = questionList.get(currentQuestion);
            a1 = questionList.get(currentQuestion).answers[0];
            a2 = questionList.get(currentQuestion).answers[1];
            myersBriggsQuiz.recordResponse(q, a2);

            //update to next question
            currentQuestion++;
            q = questionList.get(currentQuestion);
            a1 = questionList.get(currentQuestion).answers[0];
            a2 = questionList.get(currentQuestion).answers[1];
            questionText.setText(q.questionText);
            choice1.setText(a1.answerText);
            choice2.setText(a2.answerText);

            mProgress.incrementProgressBy(1);
        } else {
            Intent intent = new Intent(this, MyersBriggsResultsActivity.class);
            myersResult = myersBriggsQuiz.getResult();
            intent.putExtra(EXTRA_MESSAGE, myersResult);
            startActivity(intent);
            finish();
        }
    }
}