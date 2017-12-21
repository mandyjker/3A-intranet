package gr.hua.dit.ds.service;

import java.util.List;

import gr.hua.dit.ds.entity.Car;

public interface CarService {
	public List<Car> getCars();

	public void saveCar(Car car);
	
	public void updateCar(Car car);

	public Car getCar(String id);

	public void deleteCar(String id);
}
