package com.orangedietc.flim.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	
	// before executing handler. e.g. login validation
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// get url
//		String url = request.getRequestURI();
//		if(url.indexOf("login.action")>=0) {
//			return true;
//		}
		// determine session
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username != null) {
			return true;
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/users/login.jsp").forward(request, response);
		return false;
	}
	
	// after executing handler and before returning modelandview. 
	// e.g. add some shared data to the model(like a navigation), unify view.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	// after returning. e.g. unify exception process
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
