package com.placement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.placement.entity.Job;
import com.placement.entity.Student;
import com.placement.exceptions.NotFoundException;
import com.placement.service.StudentService;

@SpringBootTest
class PlacementMgmtSystemApplicationTests {
	
	@Autowired
	StudentService studentServ;
	
	@Test
	public void saveStudentTest() {
		Set<Job> jobSet = new HashSet<>();
		Student theStudent  = new Student(22l, "abc2", "abc", "xyz", "abcxyz@gmail.com", "1234", "1209876543", "Btech", "Female", "https://www.linkedin.com", true,jobSet);
		
		Student student = studentServ.saveAllStudent(theStudent);
		
		assertNotNull(student);
	}
	
	@Test
	public void findAllStudentTest() {
		List<Student> student = studentServ.findAllStudent();
		
		assertThat(student).size().isGreaterThan(0);
	}
	
	@Test
	public void findByStudentIdTest() {
		Student student = studentServ.findStudentById(8l);
		
		assertNotNull(student);
	}
	
	@Test
	public void findStudentByUsernameAndPasswordTest() {
		Student student = studentServ.findStudentByUsernameAndPassword("lalit", "pass");
		assertEquals("Lalit", student.getUsername());
	}
	
	
	@Test
	public void findStudentByUsernameAndPasswordTest1() {
//		Student student = studentServ.findStudentByUsernameAndPassword("lalit", "pas");
		Exception ex= assertThrows(NotFoundException.class,()->{
			studentServ.findStudentByUsernameAndPassword("lalit", "pas");
		});
		String actualMsg = ex.getMessage();
		String expectedMsg = "Invalid Credential";
		
		assertFalse(expectedMsg.equals(actualMsg));
		
	}
	@Test
	public void findStudentByIdTest() {
//		Student student = studentServ.findStudentByUsernameAndPassword("lalit", "pas");
		Exception ex= assertThrows(NotFoundException.class,()->{
			studentServ.findStudentById(7l);
		});
		String actualMsg = ex.getMessage();
		String expectedMsg = "Student not found !!, whose ID is "+7l;
		
		assertTrue(expectedMsg.equals(actualMsg));
		
	}
	
}
