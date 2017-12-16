package gr.hua.dit.ds.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.dit.ds.entity.Worker;

@Repository
public class WorkerDAOImpl implements WorkerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Worker> getWorkers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Worker> query = currentSession.createQuery("from Worker", Worker.class);
		List<Worker> workers = query.getResultList();
		return workers;
	}

	@Override
	public void saveWorker(Worker worker) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(worker);
	}

	@Override
	public Worker getWorker(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Worker worker = currentSession.get(Worker.class, id);
		return worker;
	}

	@Override
	public void deleteWorker(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Worker worker = currentSession.get(Worker.class, id);
		currentSession.delete(worker);
	}

}
