package gr.hua.dit.ds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@Column(name = "licence_plate")
	private String licencePlate;

	@Column(name = "c_model")
	private String model;

	@Column(name = "fuel_type")
	private String fuelType;

	@Column(name = "c_year")
	private int year;

	@Column(name = "c_condition")
	private String condition;

	@Column(name = "c_reward")
	private int reward;

	@Column(name = "worker_id")
	private int workerID;

	@Column(name = "customer_afm")
	private int customerAFM;

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public int getWorkerID() {
		return workerID;
	}

	public void setWorkerID(int workerID) {
		this.workerID = workerID;
	}

	public int getCustomerAFM() {
		return customerAFM;
	}

	public void setCustomerAFM(int customerAFM) {
		this.customerAFM = customerAFM;
	}

	@Override
	public String toString() {
		return "Car [licence plate=" + licencePlate + ", model=" + model 
				+ ", fuel type=" + fuelType + ", year=" + year 
				+ ", condition=" + condition + ", reward=" + reward
				+ ", worker id=" + workerID +", customer afm=" +customerAFM +"]";
	}
}
