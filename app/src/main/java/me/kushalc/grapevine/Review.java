package me.kushalc.grapevine;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kushal on 6/11/16.
 */
public class Review implements Parcelable {
    public String header;
    private String content;
    private int rating;

    public Review(){

    }

    public Review(String header, String review, int rating){
        this.content = review;
        this.header = header;
        // this.dateAndTime = dateAndTime;
        this.rating = rating;
    }

    public String getReview() {
        return content;
    }

    public int getRating() {
        return rating;
    }

    // public String getDateAndTime() {
    //      return dateAndTime;
    //   }

    public String getHeader() {
        return header;
    }

    // public void setDateAndTime(String dateAndTime) {
    // this.dateAndTime = dateAndTime;
    // }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.content = review;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    protected Review(Parcel in) {
        header = in.readString();
        content = in.readString();
        rating = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(header);
        dest.writeString(content);
        dest.writeInt(rating);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Review> CREATOR = new Parcelable.Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };
}