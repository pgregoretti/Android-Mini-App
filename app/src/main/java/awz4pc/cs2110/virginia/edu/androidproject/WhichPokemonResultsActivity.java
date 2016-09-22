package awz4pc.cs2110.virginia.edu.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WhichPokemonResultsActivity extends AppCompatActivity {
    TextView result;
    String pokemonResult;
    public static String RESULTS_MESSAGE = "You did not finish taking the quiz!";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myers_briggs_results);
        //Bundle extras = getIntent().getExtras();
        //myersType = extras.getString("result");
        Intent intent = getIntent();
        pokemonResult = intent.getStringExtra(MyersBriggsActivity.EXTRA_MESSAGE);

        result = (TextView) findViewById(R.id.myers_result_text);
        result.setText("You are a " + pokemonResult + "!");
        RESULTS_MESSAGE = pokemonResult.toString();

    }

    public void exitResults(View view) {
        /**Intent intent = new Intent(MyersBriggsResultsActivity.this, MainActivity.class);
         intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
         startActivity(intent);
         */
        Intent openMainActivity = new Intent(WhichPokemonResultsActivity.this, MainActivity.class);
        openMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        openMainActivity.putExtra(RESULTS_MESSAGE, pokemonResult);
        startActivity(openMainActivity);
    }
}
