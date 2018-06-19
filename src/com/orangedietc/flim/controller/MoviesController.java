package com.orangedietc.flim.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.orangedietc.flim.po.MoviesCustom;
import com.orangedietc.flim.po.MoviesQueryVo;
import com.orangedietc.flim.po.ReviewsCustom;
import com.orangedietc.flim.po.ReviewsQueryVo;
import com.orangedietc.flim.po.UsersCustom;
import com.orangedietc.flim.service.MoviesService;
import com.orangedietc.flim.service.ReviewsService;
import com.orangedietc.flim.service.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
/*import com.fasterxml.jackson.databind.type.TypeFactory;*/
import com.orangedietc.flim.controller.validation.ValidGroup1;
import com.orangedietc.flim.exception.CustomException;

@Controller
@RequestMapping(value="/movies", method={RequestMethod.POST, RequestMethod.GET})
public class MoviesController {
	
	@Autowired
	private MoviesService moviesService;
	
	@Autowired
	private ReviewsService reviewsService;
	
	@Autowired
	private UsersService usersService;
	
	private void processJsonDataInMovie(MoviesCustom moviesCustom) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		if(moviesCustom.getGenres() != null) {
			String[] genres = objectMapper.readValue(moviesCustom.getGenres(), String[].class);
			moviesCustom.setGenresArray(genres);
		}
		if(moviesCustom.getDirectors() != null) {
			String[] directors = objectMapper.readValue(moviesCustom.getDirectors(), String[].class);
			moviesCustom.setDirectorsArray(directors);
		}
		if(moviesCustom.getWriters() != null) {
			String[] writers = objectMapper.readValue(moviesCustom.getWriters(), String[].class);
			moviesCustom.setWritersArray(writers);
		}
		if(moviesCustom.getStars() != null) {
			String[] stars = objectMapper.readValue(moviesCustom.getStars(), String[].class);
			moviesCustom.setStarsArray(stars);
		}
		if(moviesCustom.getAka() != null) {
			String[] akas = objectMapper.readValue(moviesCustom.getAka(), String[].class);
			moviesCustom.setAkaArray(akas);
		}
		if(moviesCustom.getLanguages() != null) {
			String[] languages = objectMapper.readValue(moviesCustom.getLanguages(), String[].class);
			moviesCustom.setLanguagesArray(languages);
		}
		if(moviesCustom.getCountries() != null) {
			String[] countries = objectMapper.readValue(moviesCustom.getCountries(), String[].class);
			moviesCustom.setCountriesArray(countries);
		}
	}
	
	@RequestMapping("/queryMovies")
	public ModelAndView queryMovies(HttpServletRequest request, MoviesQueryVo moviesQueryVo) throws Exception {
		
		List<MoviesCustom> moviesList = moviesService.findMoviesList(moviesQueryVo);
		
		
		// process genres and profile
/*		TypeFactory typeFactory = objectMapper.getTypeFactory();*/
		for(MoviesCustom moviesCustom : moviesList) {
			processJsonDataInMovie(moviesCustom);
/*			List<String> genresList = objectMapper.readValue(moviesCustom.getGenres(), typeFactory.constructCollectionType(List.class, String.class));*/
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("moviesList", moviesList);
		modelAndView.setViewName("movies/moviesList");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/insertMovies", method = RequestMethod.GET)
	public ModelAndView insertMovies(HttpServletRequest request) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		MoviesCustom moviesCustom = new MoviesCustom();
		modelAndView.addObject("moviesCustom", moviesCustom);
/*		modelAndView.addObject("genres_array", new String[]{});*/
		
		modelAndView.setViewName("movies/insertMovies");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/insertMoviesSubmit", method = RequestMethod.POST)
	public String insertMoviesSubmit(Model model, @Validated(value= {ValidGroup1.class}) MoviesCustom moviesCustom, 
			BindingResult bindingResult, MultipartFile movie_poster, String[] genres_array) throws Exception {
		
		// validation
		if(bindingResult.hasErrors()) {
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			model.addAttribute("allErrors", allErrors);
			
			return "movies/insertMovies";
		}
		
		// upload poster
		if(movie_poster != null) {
			String pic_path = "/home/haoyuepeng/upload/temp/";
			String originalFilename = movie_poster.getOriginalFilename();
			if(originalFilename != null && originalFilename.length() > 0) {
				// new file name: random number plus original extension
				String newFilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
				// create a new pic file
				File newFile = new java.io.File(pic_path+newFilename);
				// write the file in memory into disk
				movie_poster.transferTo(newFile);
				// write the pic name into database
				moviesCustom.setPoster(newFilename);
			} else {
				moviesCustom.setPoster("default.jpg");
			}
		}
		ObjectMapper objectMapper = new ObjectMapper();
		// process movie profile json
		String[] directorsArray = stringToArray(moviesCustom.getDirectors());
		String[] writersArray = stringToArray(moviesCustom.getWriters());
		String[] starsArray = stringToArray(moviesCustom.getStars());
		String[] akaArray = stringToArray(moviesCustom.getAka());
		String[] languagesArray = stringToArray(moviesCustom.getLanguages());
		String[] countriesArray = stringToArray(moviesCustom.getCountries());
		if(directorsArray != null) {
			String directorsJsonArray = objectMapper.writeValueAsString(directorsArray);
			moviesCustom.setDirectors(directorsJsonArray);
		} else {
			moviesCustom.setDirectors(null);
		}
		if(writersArray != null) {
			String writersJsonArray = objectMapper.writeValueAsString(writersArray);
			moviesCustom.setWriters(writersJsonArray);
		} else {
			moviesCustom.setWriters(null);
		}
		if(starsArray != null) {
			String starsJsonArray = objectMapper.writeValueAsString(starsArray);
			moviesCustom.setStars(starsJsonArray);
		} else {
			moviesCustom.setStars(null);
		}
		if(akaArray != null) {
			String akaJsonArray = objectMapper.writeValueAsString(akaArray);
			moviesCustom.setAka(akaJsonArray);
		} else {
			moviesCustom.setAka(null);
		}
		if(languagesArray != null) {
			String languagesJsonArray = objectMapper.writeValueAsString(languagesArray);
			moviesCustom.setLanguages(languagesJsonArray);
		} else {
			moviesCustom.setLanguages(null);
		}
		if(countriesArray != null) {
			String countriesJsonArray = objectMapper.writeValueAsString(countriesArray);
			moviesCustom.setCountries(countriesJsonArray);
		} else {
			moviesCustom.setCountries(null);
		}
		
		// process genres array
		String genresJsonArray = objectMapper.writeValueAsString(genres_array);
		moviesCustom.setGenres(genresJsonArray);
		
		// initialize movie's rating capita and sum
		moviesCustom.setRatingCapita(0);
		moviesCustom.setRatingSum(0F);
		
		moviesService.insertMovie(moviesCustom);
		
		return "success";
	}
	
	private String[] stringToArray(String s) {
		s = s.trim();
		if(s.length() == 0) return null;
		String[] res = s.split(",");
		Arrays.stream(res).map(String::trim).toArray(unused -> res);
		return res;
	}
	
	@RequestMapping(value="/getMovie", method=RequestMethod.GET)
	public ModelAndView getMovie(Integer id, HttpServletRequest request, HttpSession session) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		MoviesCustom moviesCustom = moviesService.findMovieById(id);
		if(moviesCustom == null) {
			throw new CustomException("The movie doesn't exist!");
		}
		
		// update its rating
		float ratingSum = moviesCustom.getRatingSum();
		float ratingCapita = moviesCustom.getRatingCapita();
		moviesCustom.setRating(ratingSum / ratingCapita);
		moviesService.updateMovie(moviesCustom);
		
		// get logged-in user's review
		String username = (String) session.getAttribute("username");
		if(username != null && username.length() > 0) {
			ReviewsQueryVo reviewsQueryVo = new ReviewsQueryVo();
			reviewsQueryVo.setMoviesCustom(moviesCustom);
			UsersCustom usersCustom = usersService.findUserByName(username);
			reviewsQueryVo.setUsersCustom(usersCustom);
			ReviewsCustom reviewsCustom = reviewsService.findReviewByUserAndMovie(reviewsQueryVo);
			if(reviewsCustom != null) {
				modelAndView.addObject("reviewsCustom", reviewsCustom);
			}
		}
		
		// process genres
//		ObjectMapper objectMapper = new ObjectMapper();
//		String[] genres = objectMapper.readValue(moviesCustom.getGenres(), String[].class);
//		moviesCustom.setGenresArray(genres);
		processJsonDataInMovie(moviesCustom);
		
		// reviews list
		ReviewsQueryVo reviewsListQueryVo = new ReviewsQueryVo();
		reviewsListQueryVo.setMoviesCustom(moviesCustom);
		List<ReviewsCustom> reviewsCustomList = reviewsService.findReviewsListByMovie(reviewsListQueryVo);
		if(reviewsCustomList != null && reviewsCustomList.size() > 0)
			modelAndView.addObject("reviewsCustomList", reviewsCustomList);
		
		modelAndView.addObject("moviesCustom", moviesCustom);
		modelAndView.setViewName("movies/getMovie");
		
		return modelAndView;
	}
	
/*	@RequestMapping(value="/editReview", method=RequestMethod.GET)
	public ModelAndView editReview(Model model, Integer movieId, String username) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("movies/editReview", "model", model);
		MoviesCustom moviesCustom = (MoviesCustom) modelAndView.getModelMap().get("moviesCustom");
		UsersCustom usersCustom = usersService.findUserByName(username);
		
		ReviewsCustom reviewsCustom = (ReviewsCustom) modelAndView.getModelMap().getOrDefault("reviewsCustom", null);
		
		if(reviewsCustom == null) {
			// add new review
			reviewsCustom = new ReviewsCustom();
			reviewsCustom.setMovieId(movieId);
			reviewsCustom.setUserid(usersCustom.getUserid());
			modelAndView.addObject("reviewsCustom", reviewsCustom);
		} else {
			// edit existing review
		}
		return modelAndView;
	}*/
	
	
	
	@ModelAttribute("allGenres")
	public List<String> getAllGenres() {
		List<String> allGenres = new ArrayList<String>();
		allGenres.add("drama");
		allGenres.add("comedy");
		allGenres.add("action");
		allGenres.add("crime");
		allGenres.add("romance");
		allGenres.add("lgbt");
		allGenres.add("scifi");
		allGenres.add("thriller");
		allGenres.add("mystery");
		allGenres.add("fantasy");
		allGenres.add("animation");
		allGenres.add("adventure");
		return allGenres;
	}
	
	

}
