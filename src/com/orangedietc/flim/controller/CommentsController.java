package com.orangedietc.flim.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orangedietc.flim.po.CommentsCustom;
import com.orangedietc.flim.po.CommentsQueryVo;
import com.orangedietc.flim.po.ReviewsCustom;
import com.orangedietc.flim.service.CommentsService;
import com.orangedietc.flim.service.MoviesService;
import com.orangedietc.flim.service.ReviewsService;
import com.orangedietc.flim.service.UsersService;

@Controller
@RequestMapping(value="/comments", method={RequestMethod.POST, RequestMethod.GET})
public class CommentsController {

	@Autowired
	private MoviesService moviesService;
	
	@Autowired
	private ReviewsService reviewsService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private CommentsService commentsService;
	
	@RequestMapping(value="/addComment", method=RequestMethod.POST)
	public String addComment(Model model, ReviewsCustom reviewsCustom, CommentsCustom commentsCustom,
			BindingResult bindingResult, HttpSession session) throws Exception {
		// validation
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			model.addAttribute("allErrors", allErrors);
			
			return "reviews/getComments";
		}
		commentsCustom.setReviewId(reviewsCustom.getReviewId());
		CommentsQueryVo commentsQueryVo = new CommentsQueryVo();
		commentsQueryVo.setReviewsCustom(reviewsCustom);
		List<CommentsCustom> commentsList = commentsService.findCommentsListByReview(commentsQueryVo);
		Integer floors = commentsList.size();
		commentsCustom.setFloor(floors+1);
		commentsCustom.setUserid((Integer) session.getAttribute("userid"));
		commentsCustom.setUsername((String) session.getAttribute("username"));
		commentsCustom.setThumbUp(0);
		commentsCustom.setTimeStamp(new Date());
		commentsService.insertComment(commentsCustom);
		return "redirect:/reviews/getComments.action?reviewId="+reviewsCustom.getReviewId();
	}
}
