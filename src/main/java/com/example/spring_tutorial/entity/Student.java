package com.example.spring_tutorial.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity		//Indicates, this class to be mapped into DB. NOTE: DB name is in application.properties
@Table(name="students")
public class Student {
	@Id		//Indicates, this Primary Key of this Entity Class
	@GeneratedValue(strategy=GenerationType.AUTO)	//defines, generation strategy for the primary key.
	private int id;
	
	@Column()
	private int department_id;
	
	@Column(length=128, nullable=false)
	private String name;
	
	@Column(length=128, nullable=false)
	private String email;
	
	@Column(length=50, nullable=false)
	private String phone;
	
	@Column(length=128, nullable=false)
	private LocalDate dob;
	
	@Column(length=10)	//Can be null
	private String country_code;
	
	public Student() {
		
	}
	
	public Student(int id, int department_id, String name, String email, String phone, LocalDate dob, String country_code) {
		this.id = id;
		this.department_id = department_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.country_code = country_code;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getDepartmentId() {
		return department_id;
	}
	public void setDepartmentId(int department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCountryCode() {
		return country_code;
	}
	public void setCountryCode(String country_code) {
		this.country_code = country_code;
	}


	public String toString() {
		return "Student{"+"id="+id+", department_id="+department_id+", name="+name+", email="+email+", phone="+phone+"dob="+dob+"country_code="+country_code+"}";
	}
}
