package fr.istic.taa.jaxrs.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.domain.Appointment;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/appointment")
@Produces({ "application/json", "application/xml" })
public class AppointmentResource {

	@GET
	@Path("/{appointmentId}")
	public Appointment getAppointmentById(@PathParam("appointmentId") Long appointmentId) {
		// return appointment
		return new Appointment();
	}

	@POST
	@Consumes("application/json")
	public Response addAppointment(
			@Parameter(description = "Appointment object that needs to be added to the store", required = true) Appointment appointment) {
		// add appointment
		return Response.ok().entity("SUCCESS").build();
	}
}