package com.placement.service;

import java.util.List;

import com.placement.entity.Job;

public interface JobService {
	
	public Job saveOrUpdate(Job jobs);
	
	public List<Job> findAllJobs();
	
	public Job findJobById(Long id);
	
	public Job deleteJob(Long id);
	
	public List<Job> findJobByRole(String role);
	
	public List<Job> findAllByStudentId(Long id);
	
	public List<Job> findAllByRecruiterId(Long id);
	

}
