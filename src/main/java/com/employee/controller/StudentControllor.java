package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Student;
import com.employee.service.StudentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/student")
public class StudentControllor {

	@Autowired
	private StudentService service;
	
	//post data 
	
	@PostMapping("/postdata")
	public Student creatData( @Valid @RequestBody Student student) {
		  Student creatData=service.creatData(student);
		
		return creatData;
	}
	
	//get student byID
	@GetMapping("{studentId}")
	public Student getById(@PathVariable Long studentId) {
		Student byId=service.getById(studentId);
		return byId;
	}
	
	//get all student data
	@GetMapping("/getAll")
	public List<Student> getAllData(){
	List<Student> allStudent=service.getAllStudent();
	return allStudent;
	}
	
	//update student
	@PutMapping("/update/{studentId}")
	public Student updateStudent(@PathVariable Long studentId, @Valid @RequestBody Student student)
	{
		Student updateStudent=service.updateStudent(studentId, student);
		return updateStudent;
		
	}
	
	//delete student data
	@DeleteMapping("/delete/{studentId}")
	public String deleteStudent(@PathVariable Long studentId) {
		String deleteStudent=service.deleteStudent(studentId);
		return deleteStudent;
		
	}
	
	
}

