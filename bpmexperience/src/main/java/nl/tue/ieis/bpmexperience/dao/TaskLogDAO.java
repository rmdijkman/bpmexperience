package nl.tue.ieis.bpmexperience.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nl.tue.ieis.bpmexperience.model.TaskLog;

@Component
public class TaskLogDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void insert(TaskLog tl){
		em.persist(tl);		
	}

	public List<TaskLog> list(){
        TypedQuery<TaskLog> query = em.createQuery("SELECT tl FROM TaskLog tl", TaskLog.class);
        return query.getResultList();
	}
}
