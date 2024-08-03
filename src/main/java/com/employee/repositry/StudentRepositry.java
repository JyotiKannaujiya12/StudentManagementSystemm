package com.employee.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.Student;

public interface StudentRepositry extends JpaRepository<Student, Long> 
{
//Custom method 
	public Student findByFirstNameAndLastName(String firstName, String lastName) ;
		
	
		
	
}
