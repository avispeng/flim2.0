package com.orangedietc.flim.service;

import java.util.List;

import com.orangedietc.flim.po.ReviewsCustom;
import com.orangedietc.flim.po.ReviewsQueryVo;

public interface ReviewsService {
	
	public ReviewsCustom findReviewByUserAndMovie(ReviewsQueryVo reviewsQueryVo) throws Exception;
	
	public List<ReviewsCustom> findReviewsListByMovie(ReviewsQueryVo reviewsQueryVo) throws Exception;
	
	public List<ReviewsCustom> findReviewsListByUser(ReviewsQueryVo reviewsQueryVo) throws Exception;
	
	public void insertReview(ReviewsCustom reviewsCustom) throws Exception;
	
	public void updateReview(ReviewsCustom reviewsCustom) throws Exception;
	
	public ReviewsCustom findReviewById(Integer reviewId) throws Exception;
}
