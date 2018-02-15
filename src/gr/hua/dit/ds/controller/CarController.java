package gr.hua.dit.ds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.dit.ds.entity.Car;
import gr.hua.dit.ds.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

	// inject the car dao
	@Autowired
	private CarService carService;

	@GetMapping("/list")
	public String listCars(Model model) {
		// get cars from dao
		List<Car> cars = carService.getCars();
		// add the cars to the model
		model.addAttribute("cars", cars);
		// add page title
		model.addAttribute("pageTitle", "List Cars");
		return "list-cars";
	}

	@GetMapping("/{id}")
	public String getCar(Model model, @PathVariable("id") String id) {
		// get the car
		Car car = carService.getCar(id);
		model.addAttribute("car", car);
		return "car-form";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Car car = new Car();
		model.addAttribute("car", car);
		// add page title
		model.addAttribute("pageTitle", "Add Car");
		return "car-form";
	}

	@PostMapping("/saveCar")
	public String saveCar(@ModelAttribute("car") Car car) {
		car.setCondition("Undefined");
		car.setReward(0);
		carService.saveCar(car);
		return "redirect:/car/list";
	}
	
	@GetMapping("/checkCar")
	public String checkCar(Model model) {
		// create model attribute to get form data
		Car car = new Car();
		model.addAttribute("car", car);
		// add page title
		model.addAttribute("pageTitle", "Add Car");
		return "car-check-form";
	}
	
	@PostMapping("/updateCar")
	public String updateCar(@ModelAttribute("car") Car car) {
		Car tmpCar = carService.getCar(car.getLicencePlate());
		car.setCustomerAFM(tmpCar.getCustomerAFM());
		car.setFuelType(tmpCar.getFuelType());
		car.setModel(tmpCar.getModel());
		car.setWorkerID(tmpCar.getWorkerID());
		car.setYear(tmpCar.getYear());
		//calculate reward
		int years = 2018 - tmpCar.getYear();
		int reward;
		if ( years >=0 && years <=5) {
			reward = 800;
		} else if ( years >5 && years <=10 ) {
			reward = 1000;
		} else if ( years >10 && years <=20 ) {
			reward = 1200;
		} else {
			reward = 1000;
		}
		String condition = car.getCondition();
		if ( condition.startsWith("good") ) {
			reward = (int) Math.round(reward*1.0);
		} else if ( condition.startsWith("average") ) {
			reward = (int) Math.round(reward*0.8);
		} else {
			reward = (int) Math.round(reward*0.5);
		}
		car.setReward(reward);
		//save car to database
		carService.updateCar(car);
		return "redirect:/car/list";
	}
}
