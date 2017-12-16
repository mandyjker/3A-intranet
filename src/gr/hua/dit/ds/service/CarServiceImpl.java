package gr.hua.dit.ds.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.ds.dao.CarDAO;
import gr.hua.dit.ds.entity.Car;

@Service
public class CarServiceImpl implements CarService {
	
	// inject the CustomerDAO
	@Autowired
	private CarDAO carDAO;

	@Override
	@Transactional
	public List<Car> getCars() {
		return carDAO.getCars();
	}

	@Override
	@Transactional
	public void saveCar(Car car) {
		carDAO.saveCar(car);
	}

	@Override
	@Transactional
	public Car getCar(String id) {
		return carDAO.getCar(id);
	}

	@Override
	@Transactional
	public void deleteCar(String id) {
		carDAO.deleteCar(id);
	}

}
