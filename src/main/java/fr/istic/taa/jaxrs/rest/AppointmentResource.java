package fr.istic.taa.jaxrs.rest;

import java.sql.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.AppointmentDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.domain.Worker;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/appointment")
@Produces({ "application/json", "application/xml" })
public class AppointmentResource {

	@GET
	@Path("/{appointmentId}")
	public Appointment getAppointmentById(@PathParam("appointmentId") Long appointmentId) {
		AppointmentDao dao = new AppointmentDao();
		Appointment ap = dao.findOne(appointmentId);
		return ap;
	}

	@POST
	@Consumes("application/json")
	public Response addAppointment(@Parameter(name = "user", required = true) User user,
								   @Parameter(name = "worker", required = true) Worker worker,
								   @Parameter(name = "password", required = true) String password,
								   @Parameter(name="duration",required = true)int duration,
								   @Parameter(name="description", required = true) String description,
								   @Parameter(name="date", required = true)Date date) {
		AppointmentDao dao = new AppointmentDao();
		dao.create(date,duration,user,worker,description);
		return Response.ok().entity("SUCCESS").build();
	}
}