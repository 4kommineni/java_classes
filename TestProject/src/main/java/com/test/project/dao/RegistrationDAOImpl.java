package com.test.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.test.project.model.Registration;

public class RegistrationDAOImpl implements RegistrationDAO {

	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	SessionFactory sessionFactory;
		
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public String addNewUser(Registration reg) {
		String msg = "";
		try {
			Connection con = dataSource.getConnection();
			String query = "insert into user (first_name, last_name, email, password, age) values (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, reg.getFirst_name());
			pstmt.setString(2, reg.getLast_name());
			pstmt.setString(3, reg.getEmail());
			pstmt.setString(4, reg.getPassword());
			pstmt.setInt(5, reg.getAge());

			int n = pstmt.executeUpdate();
			if (n == 0) {
				msg = "Email Already Exits";
			} else {
				msg = "Succesfully registered";
			}

			pstmt.close();
			con.close();
		} catch (SQLException e) {
			msg = "DB Connection Error";
			e.printStackTrace();
		} catch (Exception e) {
			msg = "Unknown Error";
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public String addNewUserJdbcTemplate(Registration reg) {
		String msg = "";
		
		String query = "insert into user (first_name, last_name, email, password, age) values (?,?,?,?,?)";
		Object[] args= {reg.getFirst_name(), reg.getLast_name(), reg.getEmail(), reg.getPassword(), reg.getAge()};
		
		int n = jdbcTemplate.update(query, args);
		
		if (n == 0) {
			msg = "Email Already Exits";
		} else {
			msg = "Succesfully registered";
		}
		
		return msg;
	}

	@Override
	public String addNewUserViaHibernates(Registration reg) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(reg);	
		
		return null;
	}

}
