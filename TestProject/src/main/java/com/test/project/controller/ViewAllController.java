package com.test.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.project.dao.ExtraDAO;
import com.test.project.model.Registration;

@Controller
@SessionAttributes({"uid","allEmps"})
public class ViewAllController {

	@Autowired
	ExtraDAO extraDAO;
	
	
	@RequestMapping(value="viewAll", method=RequestMethod.GET)	
	public String getAllEmp(Model model,@Value("#{session.getAttribute('uid')}") String uid, @Value("#{session.getAttribute('allEmps')}") ArrayList<Registration> allEmps){
		
		if(uid==null){
			return "login";
		}
		
		if(allEmps==null){
			 allEmps= extraDAO.getAllEmp();
			 model.addAttribute("allEmps",  allEmps);
		}
		
		return "viewAll";
	}
}
