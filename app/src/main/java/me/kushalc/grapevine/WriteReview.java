package me.kushalc.grapevine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class WriteReview extends AppCompatActivity {

    private TextView title;
    private TextView content;
    private RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        title = (TextView)findViewById(R.id.writeReviewTitle);
        content = (TextView)findViewById(R.id.writeReviewContent);

        rating = (RatingBar)findViewById(R.id.starRatingBar);


    }

    public void sendReview(View view){
        Intent intent = new Intent(this,ReviewActivity.class);
        intent.putExtra("Review",new Review(title.getText().toString(),content.getText().toString(), ((int) rating.getRating())));
        startActivity(intent);
    }
}
