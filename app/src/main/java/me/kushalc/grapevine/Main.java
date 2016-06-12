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
    }

    public void populateReviewsList(){
        myReviews.add(new Review("Bad","Sample review 1 , BLAH BLAH BLAH", "5 mins ago", 4));
        myReviews.add(new Review("Terrible","Sample review 2 , BLAH BLAH BLAH", "9 mins ago", 5));
        myReviews.add(new Review("Good","Sample review 3 , BLAH BLAH BLAH", "2 days ago", 3));

    }
}
