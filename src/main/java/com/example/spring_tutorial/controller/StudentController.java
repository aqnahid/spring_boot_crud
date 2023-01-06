package com.example.spring_tutorial.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_tutorial.entity.Student;
import com.example.spring_tutorial.repositories.StudentRepo;
import com.example.spring_tutorial.service.StudentService;

//NOTE: Controller is API Layer. valid user can accesses this layer by calling API

@RestController		//this class will return REST API

@RequestMapping("/api")	//API URL

public class StudentController {
	//Repository
	
	//@Autowired: Dependency Injection. studentRepo will be automatically instanced if not initialized
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student s){
		try {
			Student student=studentRepo.save(new Student(s.getId(), s.getDepartmentId(), s.getName(), s.getEmail(), s.getPhone(), s.getDob(), s.getCountryCode()));
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> getStudents(@RequestParam(required = false) String strSearch){
		List<Student> listStudents = new ArrayList<Student>();
		try {
			if(strSearch==null) {
				studentRepo.findAll().forEach(listStudents::add);
			}
			else {
				studentRepo.findByNameContaining(strSearch).forEach(listStudents::add);
			}
			if (listStudents.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(listStudents, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	//Services: All business logics should be inside service layer.
	//In this tutorial, we are not covering any business logic yet.
	//So, I am creating a service to show only dummy student
	
	private StudentService studentService;
	
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
