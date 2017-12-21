package com.test.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="user")
public class Registration {
	
	@NotEmpty
	@Size(max=45)
	@Column(name="first_name")
	private String first_name;
	
	@NotEmpty
	@Size(max=45)
	@Column(name="last_name")
	private String last_name;
	
	@Id
	@NotEmpty(message="Email is Maditory")	
	@Size(max=45, message="MAx 45 chars is allowed")
	@Email
	@Column(name="email")
	private String email;
	
	@NotEmpty
	@Size(min=6, max=45)
	@Column(name="password")
	private String password;
	
	@Min(20)
	@Max(80)
	@Column(name="age")
	private int age;

	public Registration() {
		super();
	}

	public Registration(String first_name, String last_name, String email, String password, int age) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.age = age;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
