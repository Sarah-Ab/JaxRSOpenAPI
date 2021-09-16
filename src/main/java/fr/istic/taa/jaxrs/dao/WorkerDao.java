package fr.istic.taa.jaxrs.dao;

import java.util.List;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.Worker;

public class WorkerDao extends AbstractJpaDao<Long, Worker> {

	public void create(long id, String name, String email, String password, List<Appointment> appointments, String job) {
		Worker worker = new Worker();
		worker.setId(id);
		worker.setName(name);
		worker.setEmail(email);
		worker.setPassword(password);
		worker.setAppointments(appointments);
		worker.setJob(job);
		save(worker);
	}

}
