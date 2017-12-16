package gr.hua.dit.ds.dao;

import java.util.List;

import gr.hua.dit.ds.entity.Worker;

public interface WorkerDAO {

	public List<Worker> getWorkers();

	public void saveWorker(Worker worker);

	public Worker getWorker(int id);

	public void deleteWorker(int id);
}
