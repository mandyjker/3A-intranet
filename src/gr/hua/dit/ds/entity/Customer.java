package gr.hua.dit.ds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "afm")
	private int afm;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "worker_id")
	private int workerID;

	public Customer() {

	}

	public int getAfm() {
		return afm;
	}

	public void setAfm(int afm) {
		this.afm = afm;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getWorkerID() {
		return workerID;
	}

	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}

	@Override
	public String toString() {
		return "Customer [afm=" + afm + ", firstName=" + firstName 
				+ ", lastName=" + lastName + ", username=" + username 
				+ ", password=" + password + ", worker_id=" + workerID +"]";
	}
}
