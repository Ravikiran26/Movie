package org;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.Model.MovieRequest;

@ApplicationScoped
public class MovieServiceImpl {

	@Inject
	MovieRepository movieRepository;

	public List<Movie> getAllMovies() {
		return movieRepository.getAllMovies();
	}

	public void createMovie(MovieRequest movieRequest) {
		Movie movie = Movie.builder().description(movieRequest.getDescription()).title(movieRequest.getTitle())
				.country(movieRequest.getCountry()).director(movieRequest.getDirector()).build();
		movieRepository.createMovie(movie);

	}

	public void insertRecord(MovieRequest movieRequest) {
		Movie movie = Movie.builder().title(movieRequest.getTitle()).description(movieRequest.getDescription())
				.director(movieRequest.getDirector()).country(movieRequest.getCountry()).build();
		movieRepository.insertMovie(movie);
	}

	public Movie getMoviesById(String title) {
		return movieRepository.getMoviesById(title);
	}

	public void updateRecord(MovieRequest movieRequest) {
		Movie movie = Movie.builder().title(movieRequest.getTitle()).description(movieRequest.getDescription())
				.director(movieRequest.getDirector()).country(movieRequest.getCountry()).build();
		movieRepository.insertMovie(movie);
	}

	public void deleteRecordById(String title) {
		movieRepository.deleteRecordById(title);
	}

}
