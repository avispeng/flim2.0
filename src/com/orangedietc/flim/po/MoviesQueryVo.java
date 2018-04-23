package com.orangedietc.flim.po;

import java.util.List;

public class MoviesQueryVo {
	/**
	 * a po class that wraps up multiple po-s
	 */
	
	// a list of movies
	private List<Movies> moviesList;
	
	// one movie
	private Movies movies;
	private MoviesCustom moviesCustom;

	public MoviesCustom getMoviesCustom() {
		return moviesCustom;
	}

	public void setMoviesCustom(MoviesCustom moviesCustom) {
		this.moviesCustom = moviesCustom;
	}

	public List<Movies> getMoviesList() {
		return moviesList;
	}

	public void setMoviesList(List<Movies> moviesList) {
		this.moviesList = moviesList;
	}

	public Movies getMovies() {
		return movies;
	}

	public void setMovies(Movies movies) {
		this.movies = movies;
	}
	

}
