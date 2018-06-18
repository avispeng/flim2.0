package com.orangedietc.flim.controller;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orangedietc.flim.controller.validation.ValidGroup2;
import com.orangedietc.flim.po.ReviewsCustom;
import com.orangedietc.flim.po.ReviewsQueryVo;
import com.orangedietc.flim.po.UsersCustom;
import com.orangedietc.flim.service.ReviewsService;
import com.orangedietc.flim.service.UsersService;

@Controller
@RequestMapping(value = "/users", method = { RequestMethod.POST, RequestMethod.GET })
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private ReviewsService reviewsService;

	static final String ALPHABETNUMERIC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	private String randomString(int len) {
		/**
		 * generate a salt
		 */
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(ALPHABETNUMERIC.charAt(rnd.nextInt(ALPHABETNUMERIC.length())));
		return sb.toString();
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		UsersCustom usersCustom = new UsersCustom();
		modelAndView.addObject("usersCustom", usersCustom);
		modelAndView.setViewName("users/register");

		return modelAndView;
	}

	@RequestMapping(value = "/registerSubmit", method = RequestMethod.POST)
	public String registerSubmit(Model model, @Valid UsersCustom usersCustom,
			BindingResult bindingResult) throws Exception {
		// validation
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			model.addAttribute("allErrors", allErrors);

			return "users/register";
		}

		// determine whether the user already exists
		String username = usersCustom.getUsername();
		UsersCustom existedUser = usersService.findUserByName(username);

		if (existedUser == null || existedUser.getUserid() == null) {
			// it is valid to register
			// usersCustom.setGender(Integer.parseInt(usersCustom.getGender()));
			if (usersCustom.getNickname() == null || usersCustom.getNickname().length() == 0) {
				usersCustom.setNickname(username);
			}
			String password = usersCustom.getPassword();
			String salt = randomString(8);
			String stringToEncrypt = password + salt;
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(stringToEncrypt.getBytes());
			String hashedpwd = Hex.encodeHexString(messageDigest.digest());

			usersCustom.setHashedPwd(hashedpwd);
			usersCustom.setSalt(salt);

			usersService.InsertUser(usersCustom);
			// register succeeded, return to login page
			return "redirect:/users/login.action";

		} else {
			// failed. username already exists.
			ObjectError error = new ObjectError("register failed", "username already exists!");
			List<ObjectError> allErrors = new ArrayList<ObjectError>();
			allErrors.add(error);
			model.addAttribute("allErrors", allErrors);
			return "users/register";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		UsersCustom usersCustom = new UsersCustom();
		modelAndView.addObject("usersCustom", usersCustom);
		modelAndView.setViewName("users/login");

		return modelAndView;
	}

	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public String loginSubmit(HttpSession session, Model model,
			@Validated(value = { ValidGroup2.class }) UsersCustom usersCustom, BindingResult bindingResult)
			throws Exception {
		// validation
		if (bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();

			model.addAttribute("allErrors", allErrors);

			return "users/login";
		}

		// validate the username
		UsersCustom usersCustomFromDb = usersService.findUserByName(usersCustom.getUsername());
		if (usersCustomFromDb == null || usersCustomFromDb.getUserid() == null) {
			// username doesn't exist
			ObjectError error = new ObjectError("login failed", "username doesn't exists!");
			List<ObjectError> allErrors = new ArrayList<ObjectError>();
			allErrors.add(error);
			model.addAttribute("allErrors", allErrors);
			return "users/login";
		}
		// validate the password
		String password = usersCustom.getPassword();

		String hashedPwdFromDb = usersCustomFromDb.getHashedPwd();
		String salt = usersCustomFromDb.getSalt();
		String stringToEncrypt = password + salt;

		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(stringToEncrypt.getBytes());
		String hashedpwd = Hex.encodeHexString(messageDigest.digest());

		if (!hashedpwd.equals(hashedPwdFromDb)) {
			// wrong password
			ObjectError error = new ObjectError("login failed", "wrong password!");
			List<ObjectError> allErrors = new ArrayList<ObjectError>();
			allErrors.add(error);
			model.addAttribute("allErrors", allErrors);
			return "users/login";
		}

		// business logic validation succeeded. add to session
		session.setAttribute("username", usersCustom.getUsername());
		session.setAttribute("userid", usersCustomFromDb.getUserid());

		return "redirect:/users/getHomePage.action?userid=" + usersCustomFromDb.getUserid();

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/movies/queryMovies.action";
	}

	@RequestMapping(value = "/getHomePage", method = RequestMethod.GET)
	public ModelAndView getHomePage(Integer userid, HttpServletRequest request, HttpSession session) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		ReviewsQueryVo reviewsQueryVo = new ReviewsQueryVo();
		UsersCustom usersCustom = usersService.findUserById(userid);
		reviewsQueryVo.setUsersCustom(usersCustom);
		List<ReviewsCustom> reviewsList = reviewsService.findReviewsListByUser(reviewsQueryVo);

		if (reviewsList != null && reviewsList.size() > 0) {
			modelAndView.addObject("reviewsList", reviewsList);
		}

		modelAndView.addObject("usersCustom", usersCustom);

		modelAndView.setViewName("users/homePage");

		return modelAndView;

	}

	@ModelAttribute("citiesList")
	public List<String> getCitiesList() {
		List<String> citiesList = new ArrayList<String>();
		citiesList.add("Toronto");
		citiesList.add("Chengdu");
		citiesList.add("Guangzhou");
		citiesList.add("Vancouver");
		citiesList.add("Buenos Aires");
		citiesList.add("Taipei");
		citiesList.add("Nashville");
		citiesList.add("Cleveland");

		Collections.sort(citiesList);
		citiesList.add("Others");
		return citiesList;
	}

}
