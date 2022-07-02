package com.placement.service;

import java.util.List;

import com.placement.entity.Student;

public interface StudentService {
	
	public Student saveAllStudent(Student theStudent);
	public List<Student> findAllStudent();
	public Student updateStudentById(Long theId,Student student);
	public void deleteStudentById(Long theId);
	
//	Different method except JPA method[Self implemented.]
	
	public Student findStudentByUsernameAndPassword(String username, String password);
	public List<Student> findAllStudentByIdInDesc();
	public Student findStudentById(Long id);
}
