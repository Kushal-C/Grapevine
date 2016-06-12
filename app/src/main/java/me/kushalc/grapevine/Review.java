package me.kushalc.grapevine;

/**
 * Created by Kushal on 6/11/16.
 */
public class Review {
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
}
