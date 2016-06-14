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
        myReviews.add(new Review("Kanye West", "Great Guy" , "Fantastic Response time. Makes sure you get paid, all in all would recommend as a whole", 5));
        myReviews.add(new Review("Morghyn Mctague","Terrible to work with" , "She never payed me for our collaboration. She was mostly rude and decided that since she didn’t like what I did, that she wouldn’t pay me for the time and effort I put in. Steer clear and work with someone else!", 2));
        myReviews.add(new Review("Danish Shaik", "Massive Jerk" , "Was extremely disorganized and never paid on time or in full. Makes a lot of empty promises and can be very pretentious. Would suggest to not work with him, at all!", 2));
        myReviews.add(new Review("Kushal Cuttari", "Fantastic Writer!","Great writer and great guy! Everything we agreed on he followed through and did the job amazingly! Would definitely recommend hiring someone as creative as him!",5));
        myReviews.add(new Review("Morghyn Mctague","Does not Deserve Her Reputation!" , "She was extremely impolite and thoughtless. She only paid me in full after almost a month of when we agreed on. If you’re going to work with her, you should have a lot of patience or else it’s impossible", 2));


    }
}
