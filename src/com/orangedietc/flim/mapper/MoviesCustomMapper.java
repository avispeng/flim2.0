package com.orangedietc.flim.mapper;

import java.util.List;

import com.orangedietc.flim.po.MoviesCustom;
import com.orangedietc.flim.po.MoviesQueryVo;

public interface MoviesCustomMapper {
	
	public List<MoviesCustom> findMoviesList(MoviesQueryVo moviesQueryVo) throws Exception;

}
