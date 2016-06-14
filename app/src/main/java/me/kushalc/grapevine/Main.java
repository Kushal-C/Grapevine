package me.kushalc.grapevine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    private List<Review> myReviews = new ArrayList<Review>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView)findViewById(R.id.listView);

        populateReviewsList();

        ReviewAdapter reviewAdapter = new ReviewAdapter(this,myReviews);

        listView.setAdapter(reviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Log.i("Position Clicked",Integer.toString(position));
                Intent intent = new Intent(view.getContext(),ReviewActivity.class);
                intent.putExtra("Review",myReviews.get(position));
                //Log.i("Tag",myReviews.get(position).getHeader());
                startActivity(intent);
            }
        });
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Log.i("Toolbar Touched", myToolbar.getTouchables().toString());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_profile:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_search:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);
        return true;
    }

    public void populateReviewsList(){
        myReviews.add(new Review("Review for Mark Anthony" , "Mark Anthony is a tool, never work with this guy.", 1));
        myReviews.add(new Review("Sample review 2" , "BLAH BLAH BLAH", 5));
        myReviews.add(new Review("Sample review 3" , "BLAH BLAH BLAH", 3));

    }
}
