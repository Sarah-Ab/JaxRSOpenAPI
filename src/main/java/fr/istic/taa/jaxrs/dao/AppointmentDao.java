package fr.istic.taa.jaxrs.dao;

import java.sql.Date;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.domain.Worker;

public class AppointmentDao extends AbstractJpaDao<Long, Appointment> {

	public void create(Date date, int duration, User user, Worker worker, String description) {
		Appointment appointement = new Appointment();
		appointement.setDate(date);
		appointement.setDuration(duration);
		appointement.setUser(user);
		appointement.setWorker(worker);
		appointement.setDescription(description);
		save(appointement);
	}

}
