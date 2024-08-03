package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Student;
import com.employee.exception.CustomException.StudentNotExist;
import com.employee.repositry.StudentRepositry;


@Service
public class StudentService {
@Autowired 
private StudentRepositry repositry;
//post data
public Student creatData(Student student) {
	return repositry.save(student);
}

//get data

public Student getById(long studentId)
{
	Student byId=repositry.findById(studentId)
			.orElseThrow(()->new StudentNotExist("Student Not found With "+studentId));
	return byId;
}
	
//get all student
public List<Student> getAllStudent(){
	List<Student> all=repositry.findAll();
	return all;
}

//update code
public Student updateStudent(Long studentId,Student student) {
	Student byId=repositry .findById(studentId).get();
	byId.setFirstName(student.getFirstName());
	byId.setLastName(student.getLastName());
	byId.setAddress(student.getAddress());
	byId.setAge(student.getAge());
	Student save=repositry.save(byId);
	return save;

}

//delete student data
   public String deleteStudent(Long studentId) {
  	Student byId=repositry.findById(studentId).get();
	repositry.delete(byId);
	return "Data Successfully Deleted......";
}

}