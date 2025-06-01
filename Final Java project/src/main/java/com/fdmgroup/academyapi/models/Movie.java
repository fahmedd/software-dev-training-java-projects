package com.fdmgroup.academyapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "movies")
public class Movie {

	// TODO : Add 'No blank validation'

	@Id
	@Column(name = "movie_id")
	@SequenceGenerator(name = "MOVIE_ID_GEN", sequenceName = "movie_id_seq", initialValue = 14, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MOVIE_ID_GEN")
	private int id;

	@Column(columnDefinition = "text")
	private String image;

	private String name;

	// TODO : 0 - 5
	private Double rating;

	private String director;

	@Column(name = "release_date")
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private LocalDate releaseDate;

	private String genre;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
