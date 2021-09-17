package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.User;

public class UserDao extends AbstractJpaDao<Long, User> {

	public UserDao() {
		setClazz(User.class);
	}
	
	public void create(String name, String email, String password) {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		save(user);
	}
}
