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

import gr.hua.dit.ds.entity.Customer;
import gr.hua.dit.ds.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer dao
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		// get customers from dao
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		// add page title
		model.addAttribute("pageTitle", "List Customers");
		return "list-customers";
	}
	
	@GetMapping("/{id}")
	public String getCustomer(Model model, @PathVariable("id") String id) {
		// get the customer
		Customer customer = customerService.getCustomer(id);
		
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// create model attribute to get form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		// add page title
		model.addAttribute("pageTitle", "Add Customer");
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println("Save customer: " +customer.toString());
		// save the customer using the service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {
		// save the customer using the service
		customerService.updateCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/login")
	public String getLogin(@ModelAttribute("customer") Customer customer) {
		return "customer-login-form";
	}
	
	@GetMapping("/signin")
	public String getSignIn(@ModelAttribute("customer") Customer customer) {
		return "customer-sign-in-form";
	}
	
	@PostMapping("/customerLogin")
	public String customerLogin(@ModelAttribute("customer") Customer customer) {
		Customer tmpCustomer = customerService.getCustomer(customer.getUsername());
		if (tmpCustomer != null && tmpCustomer.getPassword().equals(customer.getPassword())) {
				return "redirect:/customer/list";
		}
		return "redirect:/customer/login";
	}
}
