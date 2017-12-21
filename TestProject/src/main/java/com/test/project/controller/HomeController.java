package com.test.project.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.test.project.dao.ExtraDAO;

/**
 * Handles requests for the application home page.
 */

@Controller
@SessionAttributes({ "uid", "allEmps"})
public class HomeController {

	@Autowired
	ExtraDAO extraDAO;

	/*
	@ModelAttribute(name="")
	public Registration setModelAttribute(){
		return new Registration();
	}*/
	
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET) // www.harsha.com
	public String home(@Value("#{session.getAttribute('uid')}") String uid) {
		if (uid != null) {
			return "viewAll";
		} else {
			return "home"; // home.jsp
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toOpenLogin(@Value("#{session.getAttribute('uid')}") String uid) {
		if (uid != null) {
			return "viewAll";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "loginSubmit", method = RequestMethod.POST)
	public String loginSubmitted(@RequestParam("emailid") String eid, @RequestParam("pswd") String pwd,
			@RequestParam(value = "intr", defaultValue = "1", required = false) String[] intr, Model model) {

		boolean isValidUser = false;

		String errorMsg = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sai", "sai", "Abc123$%");
			String query = "select count(*) from user where email='" + eid + "' and password='" + pwd + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			rs.next();

			if (rs.getInt(1) == 1) {
				isValidUser = true;
			} else {
				errorMsg = "Invalid Credentials";
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			errorMsg = "DB Connection Error";
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			errorMsg = "Unknown Error. Please Try again Latter";
			e.printStackTrace();
		}

		if (isValidUser) {
			model.addAttribute("uid", eid);
			model.addAttribute("allEmps", extraDAO.getAllEmp());
			return "viewAll";
		} else {
			model.addAttribute("loginError", errorMsg);
			return "login";
		}
	}

	@RequestMapping(value = "loginSubmit1", method = RequestMethod.POST)
	@ResponseBody
	public String loginSubmittedQuery(@RequestParam("emailid") String eid, @RequestParam("pswd") String pwd,
			@RequestParam(value = "intr", defaultValue = "1", required = false) String[] intr, Model model) {

		if (eid.equals("harsha@gmail.com") && pwd.equals("123456")) {
			return "success";
		} else {
			model.addAttribute("loginError", "Invalid User Details.");
			return "fail";
		}
	}

	@RequestMapping(value = "getDetails/{id}/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String usingPath(@PathVariable("id") int i, @PathVariable("name") String name,
			@RequestParam("APIKEY") String api) {
		return name + i;
	}

	@RequestMapping(value = "loginSubmit2", method = RequestMethod.GET)
	public String loginGETSubmitted(@RequestParam("emailid") String eid, @RequestParam("pswd") String pwd,
			@RequestParam(value = "intr", defaultValue = "1", required = false) String[] intr, Model model) {

		if (eid.equals("harsha@gmail.com") && pwd.equals("123456")) {
			return "home";
		} else {
			model.addAttribute("loginError", "Invalid User Details.");
			return "login";
		}
	}
	
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(SessionStatus sessionStatus){
		sessionStatus.setComplete();
		return "home";
	}

}
