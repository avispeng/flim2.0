package com.orangedietc.flim.mapper;

import java.util.List;

import com.orangedietc.flim.po.ReviewsCustom;
import com.orangedietc.flim.po.ReviewsQueryVo;

public interface ReviewsCustomMapper {
	
	public ReviewsCustom findReviewByUserAndMovie(ReviewsQueryVo reviewsQueryVo) throws Exception;
	
	public List<ReviewsCustom> findReviewsListByMovie(ReviewsQueryVo reviewsQueryVo) throws Exception;
	
	public List<ReviewsCustom> findReviewsListByUser(ReviewsQueryVo reviewsQueryVo) throws Exception;
}
