package com.test.project.dao;

import com.test.project.model.Registration;

public interface RegistrationDAO {
	
	public String addNewUser(Registration reg);
	
	public String addNewUserJdbcTemplate(Registration reg);
	
	public String addNewUserViaHibernates(Registration reg);
	
	
}
