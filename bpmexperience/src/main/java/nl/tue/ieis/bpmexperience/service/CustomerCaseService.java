package nl.tue.ieis.bpmexperience.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.tue.ieis.bpmexperience.dao.CustomerCaseDAO;
import nl.tue.ieis.bpmexperience.model.CustomerCase;

@Service
public class CustomerCaseService {

	@Autowired
	private CustomerCaseDAO customerCaseDAO;
		
	public List<CustomerCase> list() {
		return customerCaseDAO.list();
	}
		
	public void save(CustomerCase customerCase) {
		customerCaseDAO.save(customerCase);
	}
		
	public void delete(Long id) {
		customerCaseDAO.delete(id);
	}
		
}
