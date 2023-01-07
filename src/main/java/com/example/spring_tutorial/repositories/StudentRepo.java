package com.example.spring_tutorial.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_tutorial.entity.Student;

//NOTE: Repository is DB access Layer.
public interface StudentRepo extends JpaRepository<Student, Integer>{
	//Adding this custom method
	List<Student> findByNameContaining(String name);
}
