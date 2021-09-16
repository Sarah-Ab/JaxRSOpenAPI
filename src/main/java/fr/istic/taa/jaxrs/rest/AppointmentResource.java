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
import fr.istic.taa.jaxrs.dao.UserDao;
import fr.istic.taa.jaxrs.dao.WorkerDao;
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
	@Path("/add")
	@Consumes("application/json")
	public Response addAppointment(@Parameter(name="date", required = true)Date date,
								   @Parameter(name="duration",required = true)int duration,
								   @Parameter(name = "userId", required = true) long userId,
								   @Parameter(name = "workerId", required = true) long workerId,
								   @Parameter(name="description", required = true) String description) {
		AppointmentDao dao = new AppointmentDao();
		UserDao userdao = new UserDao();
		User user = userdao.findOne(userId);
		WorkerDao workerdao = new WorkerDao();
		Worker worker = workerdao.findOne(workerId);
		dao.create(date,duration,user,worker,description);
		return Response.ok().entity("SUCCESS").build();
	}
}