package com.placement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{

	public List<Recruiter> findByCompanyName(String companyName);
	
	public Recruiter findByRecruiterName(String name);
	
	public List<Recruiter> findAllByOrderByRecruiterNameDesc();
	

}
