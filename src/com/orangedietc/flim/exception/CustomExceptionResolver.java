package com.orangedietc.flim.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		CustomException customException = null;
		// determine if it is a custom exception
		if(ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			// a runtime error. throw unknown error to user
			customException = new CustomException("Unknown error");
		}
		String message = customException.getMessage();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("error");
		
		return modelAndView;
	}

}
