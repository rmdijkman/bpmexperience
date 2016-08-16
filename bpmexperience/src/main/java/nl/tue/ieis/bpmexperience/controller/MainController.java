package nl.tue.ieis.bpmexperience.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nl.tue.ieis.bpmexperience.model.CustomerCase;
import nl.tue.ieis.bpmexperience.service.CustomerCaseService;

@Controller
public class MainController {
	
	@Autowired
    private CustomerCaseService customerCaseService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("customerCases", customerCaseService.list() );
		
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUser() {
		
		customerCaseService.save(new CustomerCase("username_" + new Random().nextInt(1000)));
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{customerCaseId}", method = RequestMethod.GET)
	public String removeUser(@PathVariable("customerCaseId") Long customerCaseId) {
		
		customerCaseService.delete(customerCaseId);
		
		return "redirect:/";
	}
	
}
