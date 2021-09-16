package fr.istic.taa.jaxrs.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({ "application/json", "application/xml" })
public class UserResource {

	@GET
	@Path("/{userId}")
	public User getUserById(@PathParam("userId") Long userId) {
		// return user
		UserDao dao = new UserDao();
		User user = dao.findOne(userId);
		return user;
	}

	@POST
	@Consumes("application/json")
	public Response addUser(@Parameter(name = "name", required = true) String name,
			@Parameter(name = "email", required = true) String email,
			@Parameter(name = "password", required = true) String password) {
		// add user
		UserDao dao = new UserDao();
		dao.create(name, email, password, new ArrayList<>());
		return Response.ok().entity("SUCCESS").build();
	}
}