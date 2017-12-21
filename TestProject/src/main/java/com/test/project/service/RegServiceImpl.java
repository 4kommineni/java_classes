package com.test.project.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.test.project.dao.RegistrationDAO;
import com.test.project.model.Registration;

@Service
public class RegServiceImpl implements RegService {

	RegistrationDAO registrationDAO;

	public void setRegistrationDAO(RegistrationDAO registrationDAO) {
		this.registrationDAO = registrationDAO;
	}

	@Override
	@Transactional
	public String addNewUSerIntoTable(Registration reg) {
		return registrationDAO.addNewUserViaHibernates(reg);		
	}

}
