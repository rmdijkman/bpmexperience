package nl.tue.ieis.bpmexperience.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.tue.ieis.bpmexperience.dao.CustomerCaseDAO;
import nl.tue.ieis.bpmexperience.dao.TaskLogDAO;
import nl.tue.ieis.bpmexperience.model.CustomerCase;
import nl.tue.ieis.bpmexperience.model.TaskLog;

@Controller
public class MainController {
	
	@Autowired
    private CustomerCaseDAO customerCaseDAO;
	@Autowired
    private TaskLogDAO taskLogDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("customerCases", customerCaseDAO.listOneHundredNotDoneUnreserved() );
		
		return "index";
	}

	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String help() {		
		return "help";
	}

	@RequestMapping(value = "/edit/{customerCaseId}", method = RequestMethod.GET)
	public String editCustomerCase(@PathVariable("customerCaseId") Long customerCaseId, Model model, HttpServletRequest request) {
		CustomerCase cc = customerCaseDAO.find(customerCaseId);

		if (cc.getReserved() && (!cc.getReservedBy().equals(request.getSession().getId()))){
			model.addAttribute("title", "Task taken");
			model.addAttribute("message", "The task that you selected was already picked up by someone else. Appologies for the inconvenience.");
			model.addAttribute("redirect", "/");
			
			return "message";			
		}else{
			cc.setReserved(true);
			cc.setReservedBy(request.getSession().getId());
			
			customerCaseDAO.insertOrUpdate(cc);
			
			model.addAttribute("customerCase", cc);
		
			return "editcase";
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editCustomerCase(@ModelAttribute("customerCase") CustomerCase customerCase, HttpServletRequest request) {
		
		if (customerCase.getApprovalState() == null){
			customerCase.setApprovalState(0);
		}
		if (customerCase.getRiskEstimate() == null){
			customerCase.setRiskEstimate(0);
		}
		
		Integer roleNumber = (Integer) request.getSession().getAttribute("userRole");
		String role = "";
		if (roleNumber != null){
			if (roleNumber == 1){
				role = "Risk Manager";
			}else if (roleNumber == 2){
				role = "Account Manager";
			}else if (roleNumber == 3){
				role = "Administrator";
			}
		}
		saveLogItem(customerCase, request.getSession().getId(), role);
		
		customerCase.setReserved(false);
		customerCase.setNextTask(customerCase.determineNextTask());
		
		customerCaseDAO.insertOrUpdate(customerCase);
		
		return "redirect:/";
	}
	
	private void saveLogItem(CustomerCase cc, String user, String role){
		TaskLog tl = new TaskLog();
		
		tl.setCaseId(cc.getId());
		tl.setTaskName(determinePerformedTask(cc));
		tl.setRole(role);
		tl.setUser(user);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		tl.setTime(dateFormat.format(new Date()));
		
		taskLogDAO.insert(tl);
	}
	
	public String determinePerformedTask(CustomerCase cc){
		CustomerCase oldCC = customerCaseDAO.find(cc.getId());
		
		if ((oldCC.getRiskEstimate() != cc.getRiskEstimate()) ||
			!oldCC.getPayoutRate().equals(cc.getPayoutRate())
		   ){
			return CustomerCase.TASK_COMPUTE_RISK;
		}
		
		if (cc.getNextTask().equals(CustomerCase.TASK_APPROVE_DECISION)){
			return CustomerCase.TASK_APPROVE_DECISION;
		}
		
		if ((oldCC.getApprovalState() != cc.getApprovalState()) ||
			!oldCC.getReason().equals(cc.getReason()) || 
			(oldCC.getRequiresSecondary() != cc.getRequiresSecondary())
		   ){
			return CustomerCase.TASK_TAKE_DECISION;
		}
		
		if (!oldCC.getAcceptanceLetter().equals(cc.getAcceptanceLetter())
		   ){
			return CustomerCase.TASK_WRITE_ACCEPTANCE_LETTER;
		}
		
		if (!oldCC.getRejectionLetter().equals(cc.getRejectionLetter())
			   ){
			return CustomerCase.TASK_WRITE_REJECTION_LETTER;
		}
		
		return "Done nothing";
	}

	@RequestMapping(value = "/log", method = RequestMethod.GET)
	@ResponseBody
	public void showLog(HttpServletResponse response) throws IOException {
		
	    response.setContentType("text/csv; charset=utf-8");
	    response.setHeader("Content-Disposition", "attachment; filename=log.csv");
	    
	    PrintWriter writer = response.getWriter();
	    
	    for (TaskLog tl: taskLogDAO.list()){
	    	if (tl.getTaskName() != "Done nothing"){
	    		writer.print(tl.getCaseId());
	    		writer.print(",");		    
	    		writer.print(tl.getTaskName());
	    		writer.print(",");		    
	    		writer.print(tl.getTime());
	    		writer.print(",");		    
	    		writer.print(tl.getRole());
	    		writer.print(",");		    
	    		writer.print(tl.getUser());
	    		writer.print("\n");
	    	}
	    }
	    
	    writer.flush();
	    writer.close();
	}
}
