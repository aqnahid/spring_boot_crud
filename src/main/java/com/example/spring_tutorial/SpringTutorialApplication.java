package com.example.spring_tutorial;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* NOTES for Macbook User:
1: Auto complete: fn + control + space
2: Duplicate: command + option + arrow_down
*/

@SpringBootApplication
//@RestController	//activating this will make this class to return REST API. TRY!
public class SpringTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTutorialApplication.class, args);
	}
	
	//NOTE: Instead of sending API directly from here as below, we will send it from controller classes.
	//But, Here I am putting this example to demonstrate that project entry point is this main Class.
	//Uncomment the following below to TRY!
	
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
//				"aqnahid",
//				"aqnahid1@yahoo.com",
//				LocalDate.of(1980,Month.MARCH,01),
//				29
//			)
//		);
//	}
}
