package com.orangedietc.flim.po;

import java.util.List;

public class ReviewsQueryVo {
	
	private List<ReviewsCustom> reviewsList;
	
	private ReviewsCustom reviewsCustom;
	
	private Reviews reviews;
	
	private MoviesCustom moviesCustom;
	private UsersCustom usersCustom;

	public MoviesCustom getMoviesCustom() {
		return moviesCustom;
	}

	public void setMoviesCustom(MoviesCustom moviesCustom) {
		this.moviesCustom = moviesCustom;
	}

	public UsersCustom getUsersCustom() {
		return usersCustom;
	}

	public void setUsersCustom(UsersCustom usersCustom) {
		this.usersCustom = usersCustom;
	}

	public List<ReviewsCustom> getReviewsList() {
		return reviewsList;
	}

	public void setReviewsList(List<ReviewsCustom> reviewsList) {
		this.reviewsList = reviewsList;
	}

	public ReviewsCustom getReviewsCustom() {
		return reviewsCustom;
	}

	public void setReviewsCustom(ReviewsCustom reviewsCustom) {
		this.reviewsCustom = reviewsCustom;
	}

	public Reviews getReviews() {
		return reviews;
	}

	public void setReviews(Reviews reviews) {
		this.reviews = reviews;
	}
}
