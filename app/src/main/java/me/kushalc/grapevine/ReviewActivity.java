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

        name.setText(review.getHeader());
        desc.setText("Latin American Musician");
        avgRating.setText("2.3/5");

        ratingBar.setRating(2);

        populateListView();
        mReviewList.add(0,review);

        ListView listView = (ListView)findViewById(R.id.profileReviewsList);
        ReviewAdapter reviewAdapter = new ReviewAdapter(this,mReviewList);
        listView.setAdapter(reviewAdapter);

    }
    // Functionality for lower Button
    public void writeReview(View view){
        Intent intent = new Intent(this,WriteReview.class);
        startActivity(intent);
    }

    public void populateListView(){
        mReviewList.add(new Review("Mark Anthony is terrible" , "Mark Anthony is a fucking tool, never work with this non paying piece of shit.", 1));
        mReviewList.add(new Review("Not too bad a guy" , "Mark Anthony is not that bad a guy. I never undestood why it was cool to ahte him. He might be demanding at times but I'e never seen him go wrong. Don't judge him too harshly", 4));
        mReviewList.add(new Review("Mark Anthony is terrible" , "Mark Anthony is a fucking tool, never work with this non paying piece of shit.", 1));
    }
    // Used to connect with Danish's backend
    public class ProfileDownloadTask extends AsyncTask<String, Void, String>{
        @Override
        protected String doInBackground(String... params) {

            return null;
        }
    }


}
