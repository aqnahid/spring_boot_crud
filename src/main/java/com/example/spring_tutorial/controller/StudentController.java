package com.example.spring_tutorial.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
			Student student=studentRepo.save(new Student(s.getId(), s.getDepartment_id(), s.getName(), s.getEmail(), s.getPhone(), s.getDob(), s.getCountry_code()));
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> readStudents(@RequestParam(required = false) String strSearch){
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
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> readStudentById(@PathVariable("id") int id){
		Optional<Student> studentData=studentRepo.findById(id);
		
		if(studentData.isPresent()) {
			return new ResponseEntity<> (studentData.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int id, @RequestBody Student s){
		Optional<Student> studentData=studentRepo.findById(id);
		System.out.println("data: "+studentData.toString());
		try {
			if(studentData.isPresent()) {
				Student student=studentData.get();
				student.setDepartment_id(s.getDepartment_id()==null? student.getDepartment_id() : s.getDepartment_id());
				student.setName(s.getName()==null? student.getName() : s.getName());
				student.setEmail(s.getEmail()==null? student.getEmail() : s.getEmail());
				student.setPhone(s.getPhone()==null? student.getPhone() : s.getPhone());
				student.setDob(s.getDob()==null? student.getDob() : s.getDob());
				student.setCountry_code(s.getCountry_code()==null? student.getCountry_code() : s.getCountry_code());
				System.out.println("updated: "+student.toString());
				return new ResponseEntity<>(studentRepo.save(student), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") int id){
		try {
			studentRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/student")
	public ResponseEntity<HttpStatus> deleteAllStudents() {
		try {
			studentRepo.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
