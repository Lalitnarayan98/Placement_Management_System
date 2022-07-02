package com.placement.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.entity.Recruiter;
import com.placement.service.RecruiterService;

@RestController
@RequestMapping("/recruiters")
public class RecruiterRestController {

	@Autowired
	RecruiterService recruiterService;
	
	@PostMapping("/")
	public Recruiter saveRecruiter(@Valid @RequestBody Recruiter recruiter) {
		Recruiter theRecruiter = recruiterService.saveOrUpdate(recruiter);
		return theRecruiter;
	}
	
	@GetMapping("/")
	public List<Recruiter> getAllRecruiters() {
		List<Recruiter> recruiters = recruiterService.findAllRecruiters();
		return recruiters;
		
	}
	
	@GetMapping("/{companyName}")
	public List<Recruiter> getByCompanyName(@PathVariable String companyName) {
	List<Recruiter> recruiters = recruiterService.findByCompanyName(companyName);
	/*if(companyName.isEmpty())
		throw new RecuriterCustomExceptionHandler("company not found!!"); */
		return recruiters;
	}
	
	@PutMapping("/")
	public Recruiter updateRecruiter(@RequestBody Recruiter recruiter) {
		Recruiter result = recruiterService.saveOrUpdate(recruiter);
		
//		System.err.println("Updated");
		return result;
	}
	
	@DeleteMapping("/{id}")
	public String deleteRecruiter(@PathVariable Long id) {
//		Recruiter result = recruiterService.deleteRecruiterById(id);
		
			recruiterService.deleteRecruiterById(id);
			return "Recuriter is deleted";
	
	}
	
	
	
}
