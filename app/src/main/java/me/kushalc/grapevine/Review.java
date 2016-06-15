package me.kushalc.grapevine;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Kushal on 6/11/16.
 */
public class Review implements Parcelable {

    public String reviewee;
    public String header;
    private String content;

    private boolean isCompensated;

    private int rating;



    public Review(){

    }

    public Review(String reviewee, String header, String review, int rating, boolean paid){
        this.reviewee = reviewee;
        this.content = review;
        this.header = header;
        this.isCompensated = paid;
        // this.dateAndTime = dateAndTime;
        this.rating = rating;
    }

    public String getReviewee() {
        return reviewee;
    }

    public void setReviewee(String reviewee) {
        this.reviewee = reviewee;
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

    public boolean isCompensated() {
        return isCompensated;
    }

    public void setCompensated(boolean compensated) {
        isCompensated = compensated;
    }

    protected Review(Parcel in) {
        reviewee = in.readString();
        header = in.readString();
        content = in.readString();
        isCompensated = in.readByte() != 0x00;
        rating = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reviewee);
        dest.writeString(header);
        dest.writeString(content);
        dest.writeByte((byte) (isCompensated ? 0x01 : 0x00));
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