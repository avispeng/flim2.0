package com.orangedietc.flim.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.orangedietc.flim.comparator.DatetimeReverseComparator;
import com.orangedietc.flim.mapper.ReviewsCustomMapper;
import com.orangedietc.flim.mapper.ReviewsMapper;
import com.orangedietc.flim.po.Reviews;
import com.orangedietc.flim.po.ReviewsCustom;
import com.orangedietc.flim.po.ReviewsExample;
import com.orangedietc.flim.po.ReviewsQueryVo;
import com.orangedietc.flim.service.ReviewsService;

public class ReviewsServiceImpl implements ReviewsService {
	
	@Autowired
	private ReviewsCustomMapper reviewsCustomMapper;
	
	@Autowired
	private ReviewsMapper reviewsMapper;

	@Override
	public ReviewsCustom findReviewByUserAndMovie(ReviewsQueryVo reviewsQueryVo) throws Exception {
		
		
//		return reviewsCustomMapper.findReviewByUserAndMovie(reviewsQueryVo);
		Integer userid = reviewsQueryVo.getUsersCustom().getUserid();
		Integer movieId = reviewsQueryVo.getMoviesCustom().getMovieId();
		ReviewsExample reviewsExample = new ReviewsExample();
		reviewsExample.createCriteria().andMovieIdEqualTo(movieId).andUseridEqualTo(userid);
		List<Reviews> reviewsList = reviewsMapper.selectByExampleWithBLOBs(reviewsExample);
		
		if(reviewsList == null || reviewsList.size() == 0)
			return null;
		ReviewsCustom reviewsCustom = new ReviewsCustom();
		BeanUtils.copyProperties(reviewsList.get(0), reviewsCustom);
		return reviewsCustom;
	}

	@Override
	public List<ReviewsCustom> findReviewsListByMovie(ReviewsQueryVo reviewsQueryVo) throws Exception {
		
		Integer movieId = reviewsQueryVo.getMoviesCustom().getMovieId();
		ReviewsExample reviewsExample = new ReviewsExample();
		reviewsExample.createCriteria().andMovieIdEqualTo(movieId);
		List<Reviews> reviewsList = reviewsMapper.selectByExampleWithBLOBs(reviewsExample);
		
		List<ReviewsCustom> reviewsCustomList = new ArrayList<ReviewsCustom>();
		for(Reviews reviews : reviewsList) {
			ReviewsCustom reviewsCustom = new ReviewsCustom();
			BeanUtils.copyProperties(reviews, reviewsCustom);
			reviewsCustomList.add(reviewsCustom);
		}
		Collections.sort(reviewsCustomList, new DatetimeReverseComparator());
		return reviewsCustomList;
		
		//return reviewsCustomMapper.findReviewsListByMovie(reviewsQueryVo);
	}

	@Override
	public List<ReviewsCustom> findReviewsListByUser(ReviewsQueryVo reviewsQueryVo) throws Exception {
		
		List<ReviewsCustom> reviewsCustomList = reviewsCustomMapper.findReviewsListByUser(reviewsQueryVo);
		Collections.sort(reviewsCustomList, new DatetimeReverseComparator());
		return reviewsCustomList;
	}

	@Override
	public void insertReview(ReviewsCustom reviewsCustom) throws Exception {
		reviewsMapper.insert(reviewsCustom);
		
	}

	@Override
	public void updateReview(ReviewsCustom reviewsCustom) throws Exception {
		reviewsMapper.updateByPrimaryKeyWithBLOBs(reviewsCustom);
	}

	@Override
	public ReviewsCustom findReviewById(Integer reviewId) throws Exception {
		Reviews reviews = reviewsMapper.selectByPrimaryKey(reviewId);
		ReviewsCustom reviewsCustom = new ReviewsCustom();
		BeanUtils.copyProperties(reviews, reviewsCustom);
		return reviewsCustom;
	}

}
