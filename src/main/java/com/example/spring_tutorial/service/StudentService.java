package com.example.spring_tutorial.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.spring_tutorial.entity.Student;

//NOTE: Service layer beholds all business logics. No user should access this layer. Only controllers will communicate this layer

//@Component or @Service (both are same): This class must have to be instanced wherever it is used. Class object can't be null
//@Component
@Service
public class StudentService {
	
	public Student getDemoStudent() {
		return new Student(1, 1, "Md Abdul Quadir", "aqnahid@gmail.com", "+8801537525291", LocalDate.of(1990, Month.DECEMBER, 10), "BD");
	}
	
	public List<Student> getDemoStudentList() {
		return Arrays.asList(
			new Student(1, 1, "Stephen Hawkings", "stephen@gmail.com", "+67343211", LocalDate.of(1985, Month.JULY, 14), "UK"),
			new Student(1, 1, "Elon Mask", "elonmask@gmail.com", "+989787998", LocalDate.of(1990, Month.JULY, 1), "USA")
		);
	}

}
