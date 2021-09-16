package fr.istic.taa.jaxrs.dao;

import java.util.List;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.User;

public class UserDao extends AbstractJpaDao<Long, User> {
	
	public void create(String name, List<Appointment> appointments, String email, long id, String password) {
		User user = new User();
		user.setName(name);
		user.setAppointments(appointments);
		user.setEmail(email);
		user.setId(id);
		user.setPassword(password);
		save(user);
	}
}
