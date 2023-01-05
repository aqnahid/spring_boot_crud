package com.example.spring_tutorial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.*;
//import entity.Student;

/* NOTES:
1: Auto complete: fn + control + space
2: Duplicate: command + option + arrow_d
*/

@SpringBootApplication
//@RestController	//activating this will make this class to return REST API
public class SpringTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTutorialApplication.class, args);
	}
	
	//NOTE: Instead of sending API directly from here as below, we will send it from controller classes
	
	//return String as result
//	@GetMapping
//	public String hello() {
//		return "Hello world";
//	}
	
	//return JSON
//	@GetMapping
//	public List<String> helloList() {
//		return Arrays.asList("Hello","world");
//	}
	//return JSON of Object
//	@GetMapping
//	public List<Student> helloObject() {
//		return Arrays.asList(
//			new Student(
//				1,
//				"Md Abdul Quadir",
//				"aqnahid@gmail.com",
//				LocalDate.of(1993,Month.MARCH,23),
//				29
//			)
//		);
//	}
}
