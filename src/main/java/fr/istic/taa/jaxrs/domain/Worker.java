package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "Worker")
public class Worker extends User {

	private static final long serialVersionUID = -6110089337926718725L;

	private Long id;
	private String job;

	@Id
	@GeneratedValue
	@XmlElement(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@XmlElement(name = "job")
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		String str = "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", appointments={";
		for (Appointment appointment : appointments) {
			str += appointment.getId() + ",";
		}
		str += "}, job=" + job + "]";
		return str;
	}
}
