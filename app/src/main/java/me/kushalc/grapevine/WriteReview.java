package me.kushalc.grapevine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;

public class WriteReview extends AppCompatActivity {

    private EditText title;
    private EditText content;
    private RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);

        title = (EditText) findViewById(R.id.writeReviewTitle);
        content = (EditText) findViewById(R.id.writeReviewContent);

        rating = (RatingBar)findViewById(R.id.writeReviewRating);


    }

    public void sendReview(View view){
        Intent intent = new Intent(this,ReviewActivity.class);
        intent.putExtra("Review",new Review("Kanye West", title.getText().toString(),content.getText().toString(), ((int) rating.getRating())));
        startActivity(intent);
    }
}
