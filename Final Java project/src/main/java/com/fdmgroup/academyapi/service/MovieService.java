package com.fdmgroup.academyapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.academyapi.models.Movie;
import com.fdmgroup.academyapi.repository.MovieDAO;

@Service
public class MovieService {

	@Autowired
	private MovieDAO movieDAO;

	public List<Movie> getAllMovies() {
		return movieDAO.findAll();
	}

	public Movie createMovie(Movie movie) {
		if (!movieDAO.existsById(movie.getId())) {
			return movieDAO.save(movie);
		}
		return null;
	}

	public Movie getMovie(int movieId) {
		Optional<Movie> movie = movieDAO.findById(movieId);

		if (movie.isPresent()) {
			return movie.get();
		}
		return null;
	}

	public boolean updateMovie(Movie movie) {
		if (movieDAO.existsById(movie.getId())) {
			movieDAO.save(movie);
			return true;
		}
		return false;
	}

	public boolean removeMovie(int movieId) {
		if (movieDAO.existsById(movieId)) {
			movieDAO.deleteById(movieId);
			return true;
		}
		return false;
	}

}
