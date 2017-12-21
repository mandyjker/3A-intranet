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

	// inject the customer dao
	@Autowired
	private CarService carService;

	@GetMapping("/list")
	public String listCustomers(Model model) {
		// get customers from dao
		List<Car> cars = carService.getCars();
		// add the customers to the model
		model.addAttribute("cars", cars);
		// add page title
		model.addAttribute("pageTitle", "List Cars");
		return "list-cars";
	}

	@GetMapping("/{id}")
	public String getCustomer(Model model, @PathVariable("id") String id) {
		// get the customer
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
		// save the customer using the service
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
		if (car.getFuelType() == null) {
			car.setFuelType(tmpCar.getFuelType());
		}
		if (car.getModel() == null) {
			car.setModel(tmpCar.getModel());
		}
		//if (String.valueOf(car.getWorkerID()) == null) {
			car.setWorkerID(tmpCar.getWorkerID());
		//}
		//if (String.valueOf(car.getYear()) == null) {
			car.setYear(tmpCar.getYear());
		//}
		carService.updateCar(car);
		return "redirect:/car/list";
	}
}
