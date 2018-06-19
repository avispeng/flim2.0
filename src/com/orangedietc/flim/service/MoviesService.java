package com.orangedietc.flim.service;

import java.util.List;

import com.orangedietc.flim.po.MoviesCustom;
import com.orangedietc.flim.po.MoviesQueryVo;

public interface MoviesService {
	
	public List<MoviesCustom> findMoviesList(MoviesQueryVo moviesQueryVo) throws Exception;
	
	public MoviesCustom findMovieById(Integer movieId) throws Exception;
	
	public void updateMovie(MoviesCustom moviesCustom) throws Exception;
	
	public void insertMovie(MoviesCustom moviesCustom) throws Exception;

}
