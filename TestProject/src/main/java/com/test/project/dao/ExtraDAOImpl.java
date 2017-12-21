package com.test.project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.test.project.model.Registration;

public class ExtraDAOImpl implements ExtraDAO{

	
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Registration> getAllEmp() {

		ArrayList<Registration> allEmp = new ArrayList<Registration>();
		
		try {
			Connection con = dataSource.getConnection();
			String query = "select * from user";
			Statement stmt = con.createStatement();
			ResultSet rs =stmt.executeQuery(query);
			
			while(rs.next()){
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String email = rs.getString("email");
				String pass = rs.getString("password");
				int age= rs.getInt("age");
				
				Registration r = new Registration(fname,lname,email,pass,age);
				allEmp.add(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return allEmp;
	}

}
