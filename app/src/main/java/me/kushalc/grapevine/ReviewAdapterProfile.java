package me.kushalc.grapevine;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kushal on 6/12/16.
 */
public class ReviewAdapterProfile extends BaseAdapter implements ListView.OnItemClickListener {

    private Activity activity;
    private List<Review> data;
    private static LayoutInflater inflater=null;


    public ReviewAdapterProfile(Activity a, List d){
        this.activity= a;
        this.data = d;
        //Used to call an external xml file, in this case expandable_list_view.xml
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.expandable_list_view,parent,false);

        TextView header = (TextView)row.findViewById(R.id.titleTextView);
        TextView content = (TextView)row.findViewById(R.id.contentTextView);
        RatingBar ratingBar = (RatingBar)row.findViewById(R.id.starRatingBar);

        content.setText(data.get(position).getReview());
        header.setText(data.get(position).getHeader());
        ratingBar.setRating(data.get(position).getRating());
        // Add Custom ImageView at a later time to randomize the icons that pop up when people review

        return row;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("Position",Integer.toString(position));

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

}
