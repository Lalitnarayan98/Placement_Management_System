package com.placement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.Job;

public interface JobsRepository  extends JpaRepository<Job, Long>{
	
//	This method is used for find the job according to the role like- Developer,Testing, Hr
	public List<Job> findByRole(String role);
	
//	This method is used for  get the all jobs according to salary in descending order.
	public List<Job> findAllByOrderBySalaryDesc();
	
	public List<Job> findAllByStudentId(Long id);
	
	public List<Job> findAllByRecruiterId(Long id);
}
