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

	private long id;
	private String job;

	@Id
	@GeneratedValue
	@XmlElement(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return "Worker [id=" + id + ", name=" + super.getName() + ", email=" + super.getEmail() + ", password="
				+ super.getPassword() + ", appointment=" + super.getAppointments() + "job=" + job + "]";
	}
}
