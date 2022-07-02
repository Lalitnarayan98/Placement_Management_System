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

import com.placement.entity.Job;
import com.placement.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobRestController {
	
	@Autowired
	JobService jobServ;
	
	@PostMapping("/")
	public Job saveJobs(@Valid @RequestBody Job job) {
		Job theJob = jobServ.saveOrUpdate(job);
		
		return theJob;
	}
	
	@GetMapping("/")  // Ok
	public List<Job> getAllJobs() {
		List<Job> allJobs = jobServ.findAllJobs();
		return allJobs ;
	}
	
//	Doubt
	@GetMapping("/{id}")
	public Job getJobById(@PathVariable Long id) {
		Job job = jobServ.findJobById(id);
		return job;
	}
	
	@GetMapping("/byRole/{role}")
	public List<Job> getAllJobsByRole(@PathVariable String role){
		List<Job> jobs = jobServ.findJobByRole(role);
	
		return jobs ; 
	}
	@PutMapping("/")
	public Job upadteJob(@RequestBody Job job) {
		
		Job result = jobServ.saveOrUpdate(job);
		
		System.err.println("Updated");
		return result;
	}
	
//	Doubt
	@DeleteMapping("/{id}")
	public String deleteJob(@PathVariable Long id) {
		Job result = jobServ.findJobById(id);
		
		if(result.getId() == id) 
			jobServ.deleteJob(id);
			
			return "Job Deleted";	
	}
	
//	Get the job list according to Student ID
	@GetMapping("/findByStuddentId/{id}")
	public List<Job> allJobsAppliedByStudent(@PathVariable Long id){
		List<Job> jobs = jobServ.findAllByStudentId(id);
		return jobs;
	}
	
	@GetMapping("/findByRecruiterId/{id}")
	public List<Job> findByRecruiterId(@PathVariable Long id){
		List<Job> jobs= jobServ.findAllByRecruiterId(id);
		return jobs;
	}
	
	
}
