package com.example.spring_tutorial.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_tutorial.entity.Student;
import com.example.spring_tutorial.service.StudentService;

//NOTE: Controller is API Layer. valid user can accesses this layer by calling API

@RestController		//this class will return REST API

@RequestMapping(path="api/student")	//API URL

public class StudentController {
	
	private StudentService studentService;
	
	//@Autowired: Dependency Injection. StudentService will be automatically instanced if not initialized
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService=studentService;
	}
	
	@GetMapping()
	public String getStudent() {
		return "No Student found! Add /demo or /demo_list for dummy data";
	}
	
	@GetMapping("/demo")
	public Student getDemoStudent() {
		return studentService.getDemoStudent();
	}
	
	@GetMapping("/demo_list")
	public List<Student> getDemoStudentList() {
		return studentService.getDemoStudentList();
	}
}
