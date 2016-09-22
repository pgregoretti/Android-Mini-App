package awz4pc.cs2110.virginia.edu.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String myersResult = "default";
    public final static String MYERS_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("New Quizzes"));
        tabLayout.addTab(tabLayout.newTab().setText("Completed Quizzes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /** Called when the user clicks the new quiz MB button */
    public void takeQuizMB(View view) {
        Intent intent = new Intent(this, MyersBriggsActivity.class);
        findViewById(R.id.quiz_MB).setVisibility(View.GONE);
        findViewById(R.id.result_MB).setVisibility(View.VISIBLE);

        //intent.putExtra("Myers", myersResult);
        intent.putExtra(MYERS_MESSAGE, myersResult);

        startActivity(intent);
    }

    /** Called when the user clicks the new quiz WP button */
    public void takeQuizWP(View view) {
        Intent intent = new Intent(this, WhichPokemonActivity.class);
        findViewById(R.id.quiz_WP).setVisibility(View.GONE);
        findViewById(R.id.result_WP).setVisibility(View.VISIBLE);
        startActivity(intent);
    }

    /** Called when the user clicks the results MB button */
    public void showResultMB(View view) {
        Toast.makeText(MainActivity.this, "Myers Briggs Quiz Result: " + MyersBriggsResultsActivity.RESULTS_MESSAGE, Toast.LENGTH_SHORT).show();
    }

    /** Called when the user clicks the results WP button */
    public void showResultWP(View view) {
        Toast.makeText(MainActivity.this, "Pokemon Quiz Result: " + WhichPokemonResultsActivity.RESULTS_MESSAGE, Toast.LENGTH_SHORT).show();
    }

}
