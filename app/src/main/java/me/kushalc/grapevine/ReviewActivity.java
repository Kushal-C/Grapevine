package me.kushalc.grapevine;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    ArrayList<Review> mReviewList = new ArrayList<Review>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        Intent i = getIntent();

        Review review = i.getParcelableExtra("Review");
        Log.i("Review info", review.getHeader());

        TextView name = (TextView)findViewById(R.id.nameTextView);
        TextView desc = (TextView)findViewById(R.id.descTextView);
        TextView avgRating = (TextView)findViewById(R.id.averageRatingTextView);

        RatingBar ratingBar = (RatingBar)findViewById(R.id.profileAverageRating);

        name.setText(review.getReviewee());
        desc.setText("Producer & Artist");
        avgRating.setText(Integer.toString((int) ratingBar.getRating()) + "/5");

        ratingBar.setRating(ratingBar.getRating());

        populateListView();

        mReviewList.add(2,review);

        ListView listView = (ListView)findViewById(R.id.profileReviewsList);
        ReviewAdapterProfile reviewAdapter = new ReviewAdapterProfile(this,mReviewList);
        listView.setAdapter(reviewAdapter);

    }
    // Functionality for lower Button
    public void writeReview(View view){
        Intent intent = new Intent(this,WriteReview.class);
        startActivity(intent);
    }

    public void populateListView(){
        mReviewList.add(new Review("Kanye West","Kanye is terrible" , "Kanye is a tool, never work with him. Constantly overbearing and demanding things be done his way. I cannot repeat this enough, DO NOT WORK WITH HIM!", 1));
        mReviewList.add(new Review("Kanye West", "Not too bad a guy" , "Kanye is not that bad a guy. I never understood why it's cool to hate him on this app. He might be demanding at times but I'e never seen him go wrong. Don't judge him too harshly", 4));
        mReviewList.add(new Review("Kanye West", "Smooth w/ No Hassle" , "Working with Kanye was a smooth experience. Genuine nice guy, and is true to his word with anything you agree with him on", 5));
        mReviewList.add(new Review("Kanye West", "Fantastic Working Experience","After working with many different agents in the past, I never thought I’d be able to work with one that doesn’t make me feel like I have to be persistent and patient to be able to properly work and get paid. 10/10 would work with again!", 5));

    }
    // Used to connect with Danish's backend
    public class ProfileDownloadTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... params) {

            return null;
        }
    }


}
