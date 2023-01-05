package com.example.spring_tutorial.entity;

import java.time.LocalDate;

public class Student {
	private int id;
	private String name;
	private String email;
	private LocalDate dob;
	private Integer age;
	
	public Student() {}
	public Student(int id, String name, String email, LocalDate dob, Integer age) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.dob=dob;
		this.age=age;
	}
	public Student(String name, String email, LocalDate dob, Integer age) {
		this.name=name;
		this.email=email;
		this.dob=dob;
		this.age=age;
	}
	
	//getter
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getEmail() {
		return this.email;
	}
	public LocalDate getDOB() {
		return this.dob;
	}
	public Integer getAge() {
		return this.age;
	}	
	//setter
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setDOB(LocalDate dob) {
		this.dob=dob;
	}
	public void setAge(Integer age) {
		this.age=age;
	}
	
	public String toString() {
		return "Student{"+"id="+id+"name="+name+"email="+email+"dob="+dob+"age="+age+"}";
	}
}
