package awz4pc.cs2110.virginia.edu.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyersBriggsResultsActivity extends AppCompatActivity {
    TextView result;
    String myersType;
    public static String RESULTS_MESSAGE = "You did not finish taking the quiz!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myers_briggs_results);
        //Bundle extras = getIntent().getExtras();
        //myersType = extras.getString("result");
        Intent intent = getIntent();
        myersType = intent.getStringExtra(MyersBriggsActivity.EXTRA_MESSAGE);

        result = (TextView) findViewById(R.id.myers_result_text);
        result.setText("Your Myers Briggs type is " + myersType + "!");
        RESULTS_MESSAGE = myersType.toString();

    }

    public void exitResults(View view) {
        /**Intent intent = new Intent(MyersBriggsResultsActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
         */
        Intent openMainActivity = new Intent(MyersBriggsResultsActivity.this, MainActivity.class);
        openMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        openMainActivity.putExtra(RESULTS_MESSAGE, myersType);
        startActivity(openMainActivity);
    }
}
