package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Worker;

public class WorkerDao extends AbstractJpaDao<Long, Worker> {

	public WorkerDao() {
		setClazz(Worker.class);
	}
	
	public void create(String name, String email, String password, String job) {
		Worker worker = new Worker();
		worker.setName(name);
		worker.setEmail(email);
		worker.setPassword(password);
		worker.setJob(job);
		save(worker);
	}

}
