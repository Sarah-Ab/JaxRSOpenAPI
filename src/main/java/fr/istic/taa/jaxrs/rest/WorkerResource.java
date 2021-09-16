package fr.istic.taa.jaxrs.rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.WorkerDao;
import fr.istic.taa.jaxrs.domain.Worker;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/worker")
@Produces({ "application/json", "application/xml" })
public class WorkerResource {

	@GET
	@Path("/{workerId}")
	public Worker getWorkerById(@PathParam("workerId") Long workerId) {
		// return worker
		WorkerDao dao = new WorkerDao();
		Worker worker = dao.findOne(workerId);
		return worker;
	}

	@POST
	@Path("/add")
	@Consumes("application/json")
	public Response addWorker(@Parameter(name = "name", required = true) String name,
			@Parameter(name = "email", required = true) String email,
			@Parameter(name = "password", required = true) String password,
			@Parameter(name = "job", required = true) String job) {
		// add worker
		WorkerDao dao = new WorkerDao();
		dao.create(name, email, password, job, new ArrayList<>());
		return Response.ok().entity("SUCCESS").build();
	}
}