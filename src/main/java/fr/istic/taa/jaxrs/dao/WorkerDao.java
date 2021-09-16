package fr.istic.taa.jaxrs.dao;

import java.util.List;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.Worker;

public class WorkerDao extends AbstractJpaDao<Long, Worker> {

	public void create(String name, String email, String password, String job, List<Appointment> appointments) {
		Worker worker = new Worker();
		worker.setName(name);
		worker.setEmail(email);
		worker.setPassword(password);
		worker.setJob(job);
		worker.setAppointments(appointments);
		save(worker);
	}

}
