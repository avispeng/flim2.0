package com.orangedietc.flim.po;

import java.util.Date;

public class Reviews {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reviews.review_id
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    private Integer reviewId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reviews.movie_id
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    private Integer movieId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reviews.userid
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    private Integer userid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reviews.review_title
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    private String reviewTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reviews.thumb_up
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    private Integer thumbUp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reviews.time_stamp
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    private Date timeStamp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reviews.rating
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    private Integer rating;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reviews.review
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    private String review;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reviews.review_id
     *
     * @return the value of reviews.review_id
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public Integer getReviewId() {
        return reviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reviews.review_id
     *
     * @param reviewId the value for reviews.review_id
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reviews.movie_id
     *
     * @return the value of reviews.movie_id
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public Integer getMovieId() {
        return movieId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reviews.movie_id
     *
     * @param movieId the value for reviews.movie_id
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reviews.userid
     *
     * @return the value of reviews.userid
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reviews.userid
     *
     * @param userid the value for reviews.userid
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reviews.review_title
     *
     * @return the value of reviews.review_title
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public String getReviewTitle() {
        return reviewTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reviews.review_title
     *
     * @param reviewTitle the value for reviews.review_title
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle == null ? null : reviewTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reviews.thumb_up
     *
     * @return the value of reviews.thumb_up
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public Integer getThumbUp() {
        return thumbUp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reviews.thumb_up
     *
     * @param thumbUp the value for reviews.thumb_up
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reviews.time_stamp
     *
     * @return the value of reviews.time_stamp
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public Date getTimeStamp() {
        return timeStamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reviews.time_stamp
     *
     * @param timeStamp the value for reviews.time_stamp
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reviews.rating
     *
     * @return the value of reviews.rating
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reviews.rating
     *
     * @param rating the value for reviews.rating
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column reviews.review
     *
     * @return the value of reviews.review
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public String getReview() {
        return review;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column reviews.review
     *
     * @param review the value for reviews.review
     *
     * @mbg.generated Thu Apr 19 18:43:51 EDT 2018
     */
    public void setReview(String review) {
        this.review = review == null ? null : review.trim();
    }
}