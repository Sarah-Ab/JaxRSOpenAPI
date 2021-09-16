package fr.istic.taa.jaxrs.dao;

import java.util.List;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.User;

public class UserDao extends AbstractJpaDao<Long, User> {

	public void create(String name, String email, String password, List<Appointment> appointments) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setAppointments(appointments);
		save(user);
	}
}
