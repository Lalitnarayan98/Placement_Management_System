package com.placement.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.entity.Student;
import com.placement.exceptions.NotFoundException;
import com.placement.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentRestController {

	@Autowired
	StudentService studentServ;

	@PostMapping("/") // Ok
	private Student saveStudent(@Valid @RequestBody Student theStudent) {

		Student student = studentServ.saveAllStudent(theStudent);		
		return student;
	}

	@GetMapping("/")  //Ok
	private List<Student> getAllStudent() {
		List<Student> studentList = studentServ.findAllStudent();
		return studentList;
	}

	@GetMapping("/{id}") // Ok
	private Student getStudentById(@PathVariable Long id) {
		Student student = studentServ.findStudentById(id);
		
		return student;
	}


	@GetMapping("/byDesc") // Ok
	private List<Student> findAllByOrderByIdDesc() {
		List<Student> sortedByDescStudent = studentServ.findAllStudentByIdInDesc();
		return sortedByDescStudent;
	}

	@GetMapping("/login/{username}/{password}") // Ok
	private Student loginStudent(@PathVariable String username, @PathVariable String password) {

		Student getValidStudent = studentServ.findStudentByUsernameAndPassword(username, password);

		System.out.println(getValidStudent.getUsername());
		return getValidStudent;
	}

	@PutMapping("/")   // Ok
	private Student updateStudent(@Valid @RequestBody Student student) {

		Student student1 = studentServ.findStudentById(student.getId());

		System.out.println("OK");
		Student result = studentServ.updateStudentById(student1.getId(), student);
		return result;

	}
	
	@DeleteMapping("/{id}") // Ok
	private String deleteStudent(@PathVariable Long id) {

		Student student = studentServ.findStudentById(id);
		
		studentServ.deleteStudentById(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK)+"\nDeleted";
	}
}
