package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.WorkerDao;
import fr.istic.taa.jaxrs.domain.Worker;

@Path("/worker")
@Produces({ "application/json", "application/xml" })
public class WorkerResource {

	public final static WorkerDao DAO = new WorkerDao();

	@GET
	@Path("/all")
	public List<Worker> getWorkers() {
		// return workers
		List<Worker> workers = DAO.findAll();
		return workers;
	}

	@GET
	@Path("/{workerId}")
	public Worker getWorkerById(@PathParam("workerId") Long workerId) {
		// return worker
		Worker worker = DAO.findOne(workerId);
		return worker;
	}

	@POST
	@Path("/add/{name}&{email}&{password}&{job}")
	public Response addWorker(@PathParam("name") String name, @PathParam("email") String email,
			@PathParam("password") String password, @PathParam("job") String job) {
		// add worker
		DAO.create(name, email, password, job);
		return Response.ok().entity("SUCCESS").build();
	}
}