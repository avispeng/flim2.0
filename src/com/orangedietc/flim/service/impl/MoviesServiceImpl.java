package com.orangedietc.flim.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.orangedietc.flim.exception.CustomException;
import com.orangedietc.flim.mapper.MoviesCustomMapper;
import com.orangedietc.flim.mapper.MoviesMapper;
import com.orangedietc.flim.po.Movies;
import com.orangedietc.flim.po.MoviesCustom;
import com.orangedietc.flim.po.MoviesQueryVo;
import com.orangedietc.flim.service.MoviesService;

public class MoviesServiceImpl implements MoviesService {
	
	@Autowired
	private MoviesMapper moviesMapper;
	
	@Autowired
	private MoviesCustomMapper moviesCustomMapper;

	@Override
	public List<MoviesCustom> findMoviesList(MoviesQueryVo moviesQueryVo) throws Exception {
		
		return moviesCustomMapper.findMoviesList(moviesQueryVo);
	}

	@Override
	public MoviesCustom findMovieById(Integer movieId) throws Exception {
		
		Movies movies = moviesMapper.selectByPrimaryKey(movieId);
		
		// exception process
		if(movies == null) {
			throw new CustomException("This movie doesn't exist!");
		}
		
		MoviesCustom moviesCustom = new MoviesCustom();
		BeanUtils.copyProperties(movies, moviesCustom);
		
		return moviesCustom;
	}

	@Override
	public void updateMovie(Integer movieId, MoviesCustom moviesCustom) throws Exception {
		
		moviesCustom.setMovieId(movieId);
		moviesMapper.updateByPrimaryKeyWithBLOBs(moviesCustom);
	}

	@Override
	public void insertMovie(MoviesCustom moviesCustom) throws Exception {
		
		moviesMapper.insert(moviesCustom);
	}



}
