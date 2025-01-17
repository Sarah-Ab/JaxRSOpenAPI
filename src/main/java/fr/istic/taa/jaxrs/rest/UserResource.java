package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.domain.User;

@Path("/user")
@Produces({ "application/json", "application/xml" })
public class UserResource {

	public final static UserDao DAO = new UserDao();
	
	@GET
	@Path("/all")
	public List<User> getUsers() {
		// return users
		List<User> users = DAO.findAll();
		return users;
	}

	@GET
	@Path("/{userId}")
	public User getUserById(@PathParam("userId") Long userId) {
		// return user
		User user = DAO.findOne(userId);
		return user;
	}

	@POST
	@Path("/add/{name}&{email}&{password}")
	public Response addUser(@PathParam("name") String name, @PathParam("email") String email,
			@PathParam("password") String password) {
		// add user
		DAO.create(name, email, password);
		return Response.ok().entity("SUCCESS").build();
	}
}