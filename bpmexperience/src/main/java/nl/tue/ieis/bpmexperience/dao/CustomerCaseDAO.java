package nl.tue.ieis.bpmexperience.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nl.tue.ieis.bpmexperience.model.CustomerCase;

@Component
public class CustomerCaseDAO{

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(CustomerCase customerCase){
		em.persist(customerCase);
	}

	@Transactional
	public void delete(Long id){
		CustomerCase customerCase = em.getReference(CustomerCase.class, id);
		em.remove(customerCase);
	}

	public List<CustomerCase> list(){
        TypedQuery<CustomerCase> query = em.createQuery(
        		"SELECT cc FROM CustomerCase cc ORDER BY cc.id", CustomerCase.class);
        return query.getResultList();
	}
	
}
