package fr.istic.taa.jaxrs.rest;

import java.util.ArrayList;
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

	@GET
	@Path("/showall")
	public List<User> getUsers() {
		// return users
		UserDao dao = new UserDao();
		dao.setClazz(User.class);
		System.out.print("---------------------------"+User.class+"----------------------------");
		List<User> users = dao.findAll();
		System.out.println("Users:");
		for (User user : users) {
			System.out.println(user);
		}
		return users;
	}

	@GET
	@Path("/{userId}")
	public User getUserById(@PathParam("userId") Long userId) {
		// return user
		UserDao dao = new UserDao();
		User user = dao.findOne(userId);
		return user;
	}

	@POST
	@Path("/add/{name}&{email}&{password}")
	public Response addUser(@PathParam("name") String name, @PathParam("email") String email,
			@PathParam("password") String password) {
		// add user
		UserDao dao = new UserDao();
		dao.create(name, email, password, new ArrayList<>());
		return Response.ok().entity("SUCCESS").build();
	}
}