package com.placement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
//	This method used for student login using user name and password
	public Student findByUsernameAndPassword(String username,String password);
	
//	This method is used for find and save unique user name
	public Student findByUsername(String username);
	
//	Method for get list of students in ascending order by student_id 
	public List<Student> findAllByOrderByIdAsc();
	
//	Method for get list of students in descending order by student_id 
	public List<Student> findAllByOrderByIdDesc();
	
}
