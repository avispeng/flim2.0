package com.orangedietc.flim.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orangedietc.flim.exception.CustomException;
import com.orangedietc.flim.po.CommentsCustom;
import com.orangedietc.flim.po.CommentsQueryVo;
import com.orangedietc.flim.po.MoviesCustom;
import com.orangedietc.flim.po.ReviewsCustom;
import com.orangedietc.flim.po.ReviewsQueryVo;
import com.orangedietc.flim.po.UsersCustom;
import com.orangedietc.flim.service.CommentsService;
import com.orangedietc.flim.service.MoviesService;
import com.orangedietc.flim.service.ReviewsService;
import com.orangedietc.flim.service.UsersService;

@Controller
@RequestMapping(value="/reviews", method={RequestMethod.POST, RequestMethod.GET})
public class ReviewsController {
	
	@Autowired
	private ReviewsService reviewsService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private MoviesService moviesService;
	
	@Autowired
	private CommentsService commentsService;
	
	@RequestMapping(value="/editReview")
	public ModelAndView editReview(HttpServletRequest request, Integer movieId, String username) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();

		UsersCustom usersCustom = usersService.findUserByName(username);
		
/*		ReviewsCustom reviewsCustom = (ReviewsCustom) modelAndView.getModelMap().getOrDefault("reviewsCustom", null);*/
		ReviewsQueryVo reviewsQueryVo = new ReviewsQueryVo();
		MoviesCustom moviesCustom = moviesService.findMovieById(movieId);
		reviewsQueryVo.setMoviesCustom(moviesCustom);
		reviewsQueryVo.setUsersCustom(usersCustom);
		ReviewsCustom reviewsCustom = reviewsService.findReviewByUserAndMovie(reviewsQueryVo);
		
		if(reviewsCustom == null) {
			// add new review
			reviewsCustom = new ReviewsCustom();
			reviewsCustom.setMovieId(movieId);
			reviewsCustom.setUserid(usersCustom.getUserid());
			reviewsCustom.setUsername(username);
			reviewsCustom.setMovieTitle(moviesCustom.getMovieTitle());
		}
		// else edit existing review
		modelAndView.addObject("reviewsCustom", reviewsCustom);

		modelAndView.setViewName("reviews/editReview");
		return modelAndView;
	}
	
	@RequestMapping(value="/editReviewSubmit", method=RequestMethod.POST)
	public String editReviewSubmit(Model model, ReviewsCustom reviewsCustom, 
			BindingResult bindingResult, Float rating) throws Exception {
		
		// validation
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			model.addAttribute("allErrors", allErrors);
			
			return "reviews/editReview";
		}
		
		MoviesCustom moviesCustom = moviesService.findMovieById(reviewsCustom.getMovieId());
		
		if(reviewsCustom.getReviewId() == null) {
			// add new review
			reviewsCustom.setThumbUp(0);
			reviewsCustom.setTimeStamp(new Date());
			reviewsService.insertReview(reviewsCustom);
			// add new rating, update movie's rating capita and sum
			float ratingSum = moviesCustom.getRatingSum();
			ratingSum += rating;
			moviesCustom.setRatingSum(ratingSum);
			int capita = moviesCustom.getRatingCapita();
			capita++;
			moviesCustom.setRatingCapita(capita);
			moviesService.updateMovie(moviesCustom);
		} else {
			// edit existing review
			ReviewsCustom reviewsCustomFromDB = reviewsService.findReviewById(reviewsCustom.getReviewId());
			float originalRating = reviewsCustomFromDB.getRating();
			float ratingSum = moviesCustom.getRatingSum();
			ratingSum = ratingSum - originalRating + rating;
			moviesCustom.setRatingSum(ratingSum);
			moviesService.updateMovie(moviesCustom);
			
			reviewsCustomFromDB.setRating(rating);
			reviewsCustomFromDB.setReviewTitle(reviewsCustom.getReviewTitle());
			reviewsCustomFromDB.setReview(reviewsCustom.getReview());
			reviewsService.updateReview(reviewsCustomFromDB);
			
		}
		return "redirect:/movies/getMovie.action?id="+reviewsCustom.getMovieId();
	}
	
	@RequestMapping(value="/getComments", method=RequestMethod.GET)
	public ModelAndView getComments(Integer reviewId, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		ReviewsCustom reviewsCustom = reviewsService.findReviewById(reviewId);
		if(reviewsCustom == null) {
			throw new CustomException("This review doesn't exist or has been deleted!");
		}
		CommentsQueryVo commentsQueryVo = new CommentsQueryVo();
		commentsQueryVo.setReviewsCustom(reviewsCustom);
		List<CommentsCustom> commentsList = commentsService.findCommentsListByReview(commentsQueryVo);
		if(commentsList != null && commentsList.size() > 0) {
			modelAndView.addObject("commentsList", commentsList);
		}
		modelAndView.addObject("reviewsCustom", reviewsCustom);
		// add new comment
		CommentsCustom commentsCustom = new CommentsCustom();
		modelAndView.addObject("commentsCustom", commentsCustom);
		modelAndView.setViewName("reviews/getComments");
		return modelAndView;
	}
	
	@ModelAttribute("ratings")
	public List<Float> getRatings() {
		List<Float> ratings = new ArrayList<Float>();
		Float i = (float) 0;
		while(i <= 10) {
			ratings.add(i);
			i++;
		}
		return ratings;
	}

}
