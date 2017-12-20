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

import gr.hua.dit.ds.entity.Worker;
import gr.hua.dit.ds.service.WorkerService;

@Controller
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	private WorkerService workerService;

	@GetMapping("/list")
	public String listWorkers(Model model) {
		List<Worker> workers = workerService.getWorkers();
		model.addAttribute("workers", workers);
		model.addAttribute("pageTitle", "List Workers");
		return "list-workers";
	}

	@GetMapping("/getWorker/{id}")
	public String getWorker(Model model, @PathVariable("id") int id) {
		Worker worker = workerService.getWorker(id);
		model.addAttribute("worker", worker);
		return "worker-form";
	}

	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		Worker worker = new Worker();
		model.addAttribute("worker", worker);
		model.addAttribute("pageTitle", "Add Worker");
		return "worker-form";
	}

	@PostMapping("/saveWorker")
	public String saveCustomer(@ModelAttribute("worker") Worker worker) {
		workerService.saveWorker(worker);
		return "redirect:/worker/list";
	}

	@GetMapping("/login")
	public String getLogin(@ModelAttribute("worker") Worker worker) {
		return "worker-login-form";
	}

	@GetMapping("/engineerHomePage")
	public String getEngineerHome(@ModelAttribute("worker") Worker worker) {
		return "home-page-engineer";
	}

	@GetMapping("/employeeHomePage")
	public String getEmployeeHomePage(@ModelAttribute("worker") Worker worker) {
		return "home-page-employee";
	}

	@PostMapping("/workerLogin")
	public String workerLogin(@ModelAttribute("worker") Worker worker) {
		Worker tmpWorker = workerService.getWorker(worker.getId());
		if (tmpWorker != null && tmpWorker.getPassword().equals(worker.getPassword())) {
				String id = String.valueOf(tmpWorker.getId());
				if (id.startsWith("10")) {
					return "redirect:/worker/employeeHomePage";
				} else if (id.startsWith("20")) {
					return "redirect:/worker/engineerHomePage";
				}
		}
		return "redirect:/worker/login";
	}

}
