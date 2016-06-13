package me.kushalc.grapevine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    private List<Review> myReviews = new ArrayList<Review>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.listView);

        populateReviewsList();

        ReviewAdapter reviewAdapter = new ReviewAdapter(this,myReviews);
        listView.setAdapter(reviewAdapter);
    }

    public void populateReviewsList(){
        myReviews.add(new Review("Review for Mark Anthony" , "Mark Anthony is a fucking tool, never work with this non paying piece of shit.", 1));
        myReviews.add(new Review("Sample review 2" , "BLAH BLAH BLAH", 5));
        myReviews.add(new Review("Sample review 3" , "BLAH BLAH BLAH", 3));

    }
}
