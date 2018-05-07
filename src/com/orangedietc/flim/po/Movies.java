package com.orangedietc.flim.po;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class Movies {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.movie_id
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private Integer movieId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.imdb_id
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    @NotNull(message="{movies.imdbId.isNULL}")
    private String imdbId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.movie_title
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    @NotNull(message="{movies.title.isNULL}")
    private String movieTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.rating
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private Float rating;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.directors
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String directors;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.writers
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String writers;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.stars
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String stars;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.aka
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String aka;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.languages
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String languages;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.countries
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String countries;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.release_date
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private Date releaseDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.genres
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String genres;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.poster
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String poster;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.rating_capita
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private Integer ratingCapita;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.rating_sum
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private Float ratingSum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movies.summary
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    private String summary;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.movie_id
     *
     * @return the value of movies.movie_id
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public Integer getMovieId() {
        return movieId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.movie_id
     *
     * @param movieId the value for movies.movie_id
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.imdb_id
     *
     * @return the value of movies.imdb_id
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getImdbId() {
        return imdbId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.imdb_id
     *
     * @param imdbId the value for movies.imdb_id
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId == null ? null : imdbId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.movie_title
     *
     * @return the value of movies.movie_title
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.movie_title
     *
     * @param movieTitle the value for movies.movie_title
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle == null ? null : movieTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.rating
     *
     * @return the value of movies.rating
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public Float getRating() {
        return rating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.rating
     *
     * @param rating the value for movies.rating
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setRating(Float rating) {
        this.rating = rating;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.directors
     *
     * @return the value of movies.directors
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getDirectors() {
        return directors;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.directors
     *
     * @param directors the value for movies.directors
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setDirectors(String directors) {
        this.directors = directors == null ? null : directors.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.writers
     *
     * @return the value of movies.writers
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getWriters() {
        return writers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.writers
     *
     * @param writers the value for movies.writers
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setWriters(String writers) {
        this.writers = writers == null ? null : writers.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.stars
     *
     * @return the value of movies.stars
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getStars() {
        return stars;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.stars
     *
     * @param stars the value for movies.stars
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setStars(String stars) {
        this.stars = stars == null ? null : stars.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.aka
     *
     * @return the value of movies.aka
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getAka() {
        return aka;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.aka
     *
     * @param aka the value for movies.aka
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setAka(String aka) {
        this.aka = aka == null ? null : aka.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.languages
     *
     * @return the value of movies.languages
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.languages
     *
     * @param languages the value for movies.languages
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setLanguages(String languages) {
        this.languages = languages == null ? null : languages.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.countries
     *
     * @return the value of movies.countries
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getCountries() {
        return countries;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.countries
     *
     * @param countries the value for movies.countries
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setCountries(String countries) {
        this.countries = countries == null ? null : countries.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.release_date
     *
     * @return the value of movies.release_date
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.release_date
     *
     * @param releaseDate the value for movies.release_date
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.genres
     *
     * @return the value of movies.genres
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getGenres() {
        return genres;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.genres
     *
     * @param genres the value for movies.genres
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setGenres(String genres) {
        this.genres = genres == null ? null : genres.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.poster
     *
     * @return the value of movies.poster
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getPoster() {
        return poster;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.poster
     *
     * @param poster the value for movies.poster
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setPoster(String poster) {
        this.poster = poster == null ? null : poster.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.rating_capita
     *
     * @return the value of movies.rating_capita
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public Integer getRatingCapita() {
        return ratingCapita;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.rating_capita
     *
     * @param ratingCapita the value for movies.rating_capita
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setRatingCapita(Integer ratingCapita) {
        this.ratingCapita = ratingCapita;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.rating_sum
     *
     * @return the value of movies.rating_sum
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public Float getRatingSum() {
        return ratingSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.rating_sum
     *
     * @param ratingSum the value for movies.rating_sum
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setRatingSum(Float ratingSum) {
        this.ratingSum = ratingSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movies.summary
     *
     * @return the value of movies.summary
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public String getSummary() {
        return summary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movies.summary
     *
     * @param summary the value for movies.summary
     *
     * @mbg.generated Sat May 05 18:47:14 EDT 2018
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }
}