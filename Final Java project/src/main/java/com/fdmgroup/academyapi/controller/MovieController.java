package com.fdmgroup.academyapi.controller;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.academyapi.models.Movie;
import com.fdmgroup.academyapi.service.MovieService;

@RestController
@RequestMapping("/api/v1/movie")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
	
	private static Logger logger = LogManager.getLogger(MovieController.class);

	@Autowired
	private MovieService movieService;

	@GetMapping
	public List<Movie> getMovies() {
		logger.trace("Get all Movies method called");
		return movieService.getAllMovies();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable int id) {
		logger.trace("Get Movie by Id Method called");
		Movie movie = movieService.getMovie(id);

		if (movie != null) {
			logger.info("Movie received");
			return ResponseEntity.status(HttpStatus.OK).body(movie);
		}
		logger.debug("Unable to get Movie");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable int id) {
		logger.trace("Delete movie method called");
		if (movieService.removeMovie(id)) {
			logger.info("Movie deleted");
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		logger.debug("Unable to delete Movie");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		logger.trace("Create Movie oject attempted");
		Movie createdMovie = movieService.createMovie(movie);

		if (createdMovie != null) {
			logger.info("Movie created");
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{MovieId}")
					.buildAndExpand(createdMovie.getId()).toUri();
			return ResponseEntity.created(location).body(createdMovie);
		}
		logger.debug("Unable to create Movie");
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}

	@PutMapping
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie Movie) {
		logger.trace("Update Movie method called");
		if (movieService.updateMovie(Movie)) {
			logger.info("Updated Movie");
			return ResponseEntity.ok(Movie);
		}
		logger.debug("Unable to update Movie");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
