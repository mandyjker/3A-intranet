package gr.hua.dit.ds.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gr.hua.dit.ds.entity.Car;
import gr.hua.dit.ds.entity.CarList;
import gr.hua.dit.ds.service.CarService;

@RestController
@RequestMapping("/api/car")
public class CarApiController {

	@Autowired
	private CarService carService;

	@Autowired
	private CarList carList;

	// get list of cars
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public CarList getListCars() {

		List<Car> carsList = carService.getCars();
		System.out.println("List of cars: " + carsList);
		this.carList.setCarList(carsList);
		return this.carList;
	}

	// save car
	@RequestMapping(value = "/jsonaddcar", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public Car createCarFromJson(@RequestBody Car car) {
		carService.saveCar(car);
		return car;
	}

	// update car
	@RequestMapping(value = "/updateCar", method = RequestMethod.POST, produces = { "application/json",
			"application/xml" })
	public Car createCar(@RequestParam("licence_plate") String licence_plate,
			@RequestParam("customer_afm") String customer_afm) {
		Car car = new Car();
		car.setLicencePlate(licence_plate);
		car.setCustomerAFM(Integer.valueOf(customer_afm));
		Car temp = carService.getCar(licence_plate);
		car.setModel(temp.getModel());
		car.setCondition(temp.getCondition());
		car.setFuelType(temp.getFuelType());
		car.setReward(temp.getReward());
		car.setYear(temp.getYear());
		car.setWorkerID(temp.getWorkerID());
		carService.saveCar(car);
		return car;
	}

	// get car
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Car getCar(@PathVariable("id") String id) {

		Car car = carService.getCar(id);
		System.out.println("car: " + car);
		return car;

	}

	// delete car
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = { "application/json",
			"application/xml" })
	public ResponseEntity deleteCar(@PathVariable("id") String id) {
		carService.deleteCar(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
