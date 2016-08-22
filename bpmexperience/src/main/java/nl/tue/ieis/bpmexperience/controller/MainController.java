package nl.tue.ieis.bpmexperience.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.tue.ieis.bpmexperience.dao.CustomerCaseDAO;
import nl.tue.ieis.bpmexperience.model.CustomerCase;

@Controller
public class MainController {
	
	@Autowired
    private CustomerCaseDAO customerCaseDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("customerCases", customerCaseDAO.listOneHundredNotDoneUnreserved() );
		
		return "index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("customerCases", customerCaseDAO.list() );
		
		return "home";
	}
	
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String help() {		
		return "help";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser() {
		
		customerCaseDAO.insertOrUpdate(new CustomerCase("username_" + new Random().nextInt(1000)));
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{customerCaseId}", method = RequestMethod.GET)
	public String removeUser(@PathVariable("customerCaseId") Long customerCaseId) {
		
		customerCaseDAO.delete(customerCaseId);
		
		return "redirect:/";
	}

	@RequestMapping(value = "/edit/{customerCaseId}", method = RequestMethod.GET)
	public String editCustomerCase(@PathVariable("customerCaseId") Long customerCaseId, Model model) {
		CustomerCase cc = customerCaseDAO.find(customerCaseId);

		if (cc.getReserved()){
			model.addAttribute("title", "Task taken");
			model.addAttribute("message", "The task that you selected was already picked up by someone else. Appologies for the inconvenience.");
			model.addAttribute("redirect", "/");
			
			return "message";			
		}else{
			cc.setReserved(true);
			
			customerCaseDAO.insertOrUpdate(cc);
			
			model.addAttribute("customerCase", cc);
		
			return "editcase";
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editCustomerCase(@ModelAttribute("customerCase") CustomerCase customerCase) {
		
		customerCaseDAO.insertOrUpdate(customerCase);
		
		return "redirect:/edit/" + customerCase.getId();
	}
}
