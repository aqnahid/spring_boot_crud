package com.example.spring_tutorial.service;

import java.lang.reflect.Array;
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
		return new Student(
			1,
			"Md Abdul Quadir",
			"aqnahid@gmail.com",
			LocalDate.of(1993,Month.MARCH,23),
			29
		);
	}
	
	public List<Student> getDemoStudentList() {
		return Arrays.asList(
			new Student(
				1,
				"Md Abdul Quadir",
				"aqnahid@gmail.com",
				LocalDate.of(1993,Month.MARCH,23),
				29
			),
			new Student(
				2,
				"Abu Yusuf",
				"yusuf@gmail.com",
				LocalDate.of(1992,Month.OCTOBER,7),
				30
			)
		);
	}

}
