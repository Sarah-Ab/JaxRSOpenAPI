package fr.istic.taa.jaxrs.rest;

import java.sql.Date;
import java.util.List;

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

@Path("/appointment")
@Produces({ "application/json", "application/xml" })
public class AppointmentResource {

	public final static AppointmentDao DAO = new AppointmentDao();

	@GET
	@Path("/all")
	public List<Appointment> getAppointments() {
		// return appointments
		List<Appointment> appointments = DAO.findAll();
		return appointments;
	}

	@GET
	@Path("/{appointmentId}")
	public Appointment getAppointmentById(@PathParam("appointmentId") Long appointmentId) {
		// return appointment
		Appointment appointment = DAO.findOne(appointmentId);
		return appointment;
	}

	@POST
	@Path("/add/{date}&{duration}&{userId}&{workerId}&{description}")
	public Response addAppointment(@PathParam("date") Date date, @PathParam("duration") int duration,
			@PathParam("userId") Long userId, @PathParam("workerId") Long workerId,
			@PathParam("description") String description) {
		// add appointment
		User user = UserResource.DAO.findOne(userId);
		Worker worker = WorkerResource.DAO.findOne(workerId);
		DAO.create(date, duration, user, worker, description);
		return Response.ok().entity("SUCCESS").build();
	}
}