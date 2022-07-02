package com.placement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.entity.Student;
import com.placement.exceptions.NotFoundException;
import com.placement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	StudentRepository studentRepo;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public Student saveAllStudent(Student theStudent) {

		Student result = studentRepo.findByUsername(theStudent.getUsername());
		if (result != null) {
			throw new NotFoundException("Username Already registerd, Try with different username ?");
		} else {
			Student student = studentRepo.save(theStudent);
			return student;
		}
	}

	@Override
	public List<Student> findAllStudent() {
		List<Student> allStudent = studentRepo.findAll();
		if (allStudent.size() == 0) {
			throw new NotFoundException("Student list is empty !!!");
		}

		return allStudent;
	}

	@Override
	public Student updateStudentById(Long theId, Student student) {
		Student result = findStudentById(theId);
		if (result != null) {
			studentRepo.save(student);
			return student;
		} else
			throw new NotFoundException("Student  is not available !!!");

	}

	@Override
	public void deleteStudentById(Long theId) {
		Optional<Student> result = studentRepo.findById(theId);

//		Student student = new Student();
		if (result != null)
			studentRepo.deleteById(theId);

		else
			throw new NotFoundException("Student is not available !!!");
	}

	@Override
	public Student findStudentByUsernameAndPassword(String username, String password) {

		Student student = studentRepo.findByUsernameAndPassword(username, password);

		if (student == null)
			throw new NotFoundException("Invalid Credential !!!");
		return student;
	}

	@Override
	public Student findStudentById(Long id) {
		Optional<Student> result = studentRepo.findById(id);

		Student student = null;
		if (result.isPresent()) {
			student = result.get();
		} else {
			throw new NotFoundException("Student not found !!, whose ID is " + id);
		}
		return student;
	}

	@Override
	public List<Student> findAllStudentByIdInDesc() {
		List<Student> sortedByDescStudent = studentRepo.findAllByOrderByIdDesc();

		if (sortedByDescStudent.size() == 0) {
			throw new NotFoundException("Student list is empty !!!");
		}
		return sortedByDescStudent;
	}

}
