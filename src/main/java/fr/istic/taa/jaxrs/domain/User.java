package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "User")
public class User implements Serializable {

	private static final long serialVersionUID = -7523683009774086865L;

	private Long id;
	protected String name;
	protected String email;
	protected String password;
	protected List<Appointment> appointments = new ArrayList<Appointment>();

	@Id
	@GeneratedValue
	@XmlElement(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@XmlElementWrapper(name = "appointments")
	@XmlElement(name = "appointment")
	@OneToMany(mappedBy = "date")
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		String str = "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", appointments={";
		for (Appointment appointment : appointments) {
			str += appointment.getId() + ",";
		}
		str += "}]";
		return str;
	}

}
