package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	MailRepository mailRepository;
	
	@Autowired
	TransactionRepository transaction;

	@RequestMapping("/departments")
	public String departments(Model model) {
        model.addAttribute("department", departmentRepository.findAll());
        return "department";
	}

    @RequestMapping(value="/saveMailId/{id}",method=RequestMethod.GET)
	public String saveMailId(@PathVariable long id,Model model) {
    	Department department = departmentRepository.findOne(id);
    	for(Mail m :department.getMail()){
	    	Transaction t = new Transaction();
	    	t.setMailId(m.getMailId()+"@"+department.getName()+".com");
	    	t.setStatus("N");
	    	transaction.save(t);
    	}
        return "approval";
	}
    
    @RequestMapping("/authorize")
	public String authorize(Model model) {
        model.addAttribute("transactions", transaction.getMailByStatus("N"));
        return "authorize";
	}
    
    @RequestMapping(value="/authorize/{transId}",method=RequestMethod.GET)
    @ResponseBody
	public String getTransDetails(@RequestParam String status, @PathVariable long transId,Model model) {
    	Transaction t = transaction.findOne(transId);
        model.addAttribute("transaction", t);
        //Here we are cheking whether the status is already modified for the particular mailId
        if(status!=null && status.equals(t.getStatus()))
        	return "0";
        //returns 0 if there is no modification is status.
        else
        	return "Status has been already changed to "+t.getStatus()+" by another manager";
        
	}
    
    @RequestMapping(value="/authorize/{status}/{transId}",method=RequestMethod.POST)
    @ResponseBody
	public String acceptOrReject(@PathVariable String status,@PathVariable long transId,Model model) {
    	Transaction t = transaction.findOne(transId);
    	t.setStatus(status.trim());
    	transaction.save(t);
    	Transaction t1 = transaction.findOne(transId);
    	model.addAttribute("transaction", transaction.findOne(transId));
    	return t1.getStatus();
	}

}
