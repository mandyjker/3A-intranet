package gr.hua.dit.ds.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gr.hua.dit.ds.dao.WorkerDAO;
import gr.hua.dit.ds.entity.Worker;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerDAO workerDAO;
	
	@Override
	@Transactional
	public List<Worker> getWorkers() {
		return workerDAO.getWorkers();
	}

	@Override
	@Transactional
	public void saveWorker(Worker worker) {
		workerDAO.saveWorker(worker);
	}

	@Override
	@Transactional
	public Worker getWorker(int id) {
		return workerDAO.getWorker(id);
	}

	@Override
	@Transactional
	public void deleteWorker(int id) {
		workerDAO.deleteWorker(id);
	}

}

