package com.orangedietc.flim.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orangedietc.flim.po.MoviesCustom;
import com.orangedietc.flim.po.ReviewsCustom;
import com.orangedietc.flim.po.ReviewsQueryVo;
import com.orangedietc.flim.po.UsersCustom;
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
		
		if(reviewsCustom.getReviewId() == null) {
			// add new review
			reviewsCustom.setThumbUp(0);
			reviewsCustom.setTimeStamp(new Date());
			reviewsService.insertReview(reviewsCustom);
		} else {
			// edit existing review
			ReviewsCustom reviewsCustomFromDB = reviewsService.findReviewById(reviewsCustom.getReviewId());
			reviewsCustomFromDB.setRating(rating);
			reviewsCustomFromDB.setReviewTitle(reviewsCustom.getReviewTitle());
			reviewsCustomFromDB.setReview(reviewsCustom.getReview());
			reviewsService.updateReview(reviewsCustomFromDB);
		}

		
		return "redirect:/movies/getMovie.action?id="+reviewsCustom.getMovieId();

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
