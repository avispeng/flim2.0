package com.orangedietc.flim.po;

public class MoviesCustom extends Movies {
	
	private String[] genresArray;
	private String[] directorsArray;
	private String[] writersArray;
	private String[] starsArray;
	private String[] akaArray;
	private String[] languagesArray;
	private String[] countriesArray;

	public String[] getDirectorsArray() {
		return directorsArray;
	}

	public void setDirectorsArray(String[] directorsArray) {
		this.directorsArray = directorsArray;
	}

	public String[] getWritersArray() {
		return writersArray;
	}

	public void setWritersArray(String[] writersArray) {
		this.writersArray = writersArray;
	}

	public String[] getStarsArray() {
		return starsArray;
	}

	public void setStarsArray(String[] starsArray) {
		this.starsArray = starsArray;
	}

	public String[] getAkaArray() {
		return akaArray;
	}

	public void setAkaArray(String[] akaArray) {
		this.akaArray = akaArray;
	}

	public String[] getLanguagesArray() {
		return languagesArray;
	}

	public void setLanguagesArray(String[] languagesArray) {
		this.languagesArray = languagesArray;
	}

	public String[] getCountriesArray() {
		return countriesArray;
	}

	public void setCountriesArray(String[] countriesArray) {
		this.countriesArray = countriesArray;
	}

	public String[] getGenresArray() {
		return genresArray;
	}

	public void setGenresArray(String[] genresArray) {
		this.genresArray = genresArray;
	}

}
