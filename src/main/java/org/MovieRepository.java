package org;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class MovieRepository implements PanacheRepositoryBase<Movie, String> {

	public List<Movie> getAllMovies() {
		return Movie.listAll();
	}

	@Transactional
	public void createMovie(Movie movie) {

		Movie.persist(movie);
	}

	@Transactional
	public void insertMovie(Movie movie) {
		Movie.persist(movie);
	}

	public Movie getMoviesById(String title) {
		return Movie.findById(title);
	}

	public void deleteRecordById(String title) {
		Movie.deleteById(title);
	}

}
