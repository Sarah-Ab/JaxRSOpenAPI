package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.domain.Worker;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/worker")
@Produces({ "application/json", "application/xml" })
public class WorkerResource {

	@GET
	@Path("/{workerId}")
	public Worker getWorkerById(@PathParam("workerId") Long workerId) {
		// return worker
		return new Worker();
	}

	@POST
	@Consumes("application/json")
	public Response addWorker(
			@Parameter(description = "Worker object that needs to be added to the store", required = true) Worker worker) {
		// add worker
		return Response.ok().entity("SUCCESS").build();
	}
}