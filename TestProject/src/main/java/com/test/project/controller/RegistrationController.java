package com.test.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.project.dao.RegistrationDAO;
import com.test.project.model.Registration;
import com.test.project.service.RegService;

@Controller
@SessionAttributes({ "uid" })
public class RegistrationController {

	@Autowired
	RegistrationDAO regDAO;
	
	@Autowired
	RegService regService;

	@RequestMapping(value = "reg", method = RequestMethod.GET)
	public String openRegPage(Model model, @Value("#{session.getAttribute('uid')}") String uid) {

		if (uid != null) {
			return "viewAll";
		} else {
			model.addAttribute("reg", new Registration());
			return "registration";
		}
	}

	@RequestMapping(value = "regSubmit", method = RequestMethod.POST)
	public String regSubmitted(@Valid @ModelAttribute("reg") Registration reg, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		//String msg = regDAO.addNewUserJdbcTemplate(reg);
		String msg = regService.addNewUSerIntoTable(reg);

		if (msg.equals("Succesfully registered")) {
			return "login";
		} else {
			model.addAttribute("regError", msg);
			return "registration";
		}
	}
}
