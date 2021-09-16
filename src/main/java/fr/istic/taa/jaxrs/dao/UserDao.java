package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.domain.Worker;

import java.util.Collections;
import java.util.List;

public class UserDao extends AbstractJpaDao <Long, Appointment> {
    public void create(String name, List <Appointment> appointments , String email, long id,String password){
        User user=new User();
        user.setName(name);
        user.setAppointments(appointments);
        user.setEmail(email);
        user.setId(id);
        user.setPassword(password);
    }
}
