package fr.istic.taa.jaxrs.dao;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Appointment;
import fr.istic.taa.jaxrs.domain.User;
import fr.istic.taa.jaxrs.domain.Worker;

import java.util.Collections;
import java.util.List;

public class UserDao extends AbstractJpaDao <Long, Appointment> {
    public void create(String name, List <Appointment> appointements , String email, long id,String pwd){
        User user=new User();
        user.setName(name);
        user.setAppointments(appointements);
        user.setEmail(email);
        user.setId(id);
        user.setPassword(pwd);
    }
}
