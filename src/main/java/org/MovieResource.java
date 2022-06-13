package org;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.Model.MovieRequest;
import org.Utils.ServiceException;

import lombok.extern.slf4j.Slf4j;

@Path("/movies")
@Slf4j
@ApplicationScoped
public class MovieResource {

	@Inject
	MovieServiceImpl movieServiceImpl;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMovies() {
		List<Movie> movies = movieServiceImpl.getAllMovies();
		return Response.ok(movies).build();

	}

	@GET
	@Path("/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("title") String title) {
		Movie movies = movieServiceImpl.getMoviesById(title);
		return Response.ok(movies).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertRecord(MovieRequest movieRequest) {
		try {
			movieServiceImpl.insertRecord(movieRequest);
			return Response.ok().build();
		} catch (ServiceException e) {
			return Response.serverError().build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateRecord(MovieRequest movieRequest) {

		try {
			movieServiceImpl.updateRecord(movieRequest);
			return Response.ok().build();
		} catch (ServiceException e) {
			return Response.serverError().build();
		}
	}

	@DELETE
	@Path("/{title}")
	public Response deleteRecordById(@PathParam("title") String title) {
		movieServiceImpl.deleteRecordById(title);
		return Response.ok().build();
	}

}