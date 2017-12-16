package gr.hua.dit.ds.dao;

import java.util.List;

import gr.hua.dit.ds.entity.Car;

public interface CarDAO {
	public List<Car> getCars();

	public void saveCar(Car car);

	public Car getCar(String id);

	public void deleteCar(String id);
}
