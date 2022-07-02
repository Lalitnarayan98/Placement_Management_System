package com.placement.service;

import java.util.List;

import com.placement.entity.Recruiter;

public interface RecruiterService {
	
	public Recruiter saveOrUpdate(Recruiter recruiter);
	
	public List<Recruiter> findAllRecruiters();
	
	public Recruiter findByRecruiterName(String name);
	
	public Recruiter findRecruiterById(Long id);
	
	public Recruiter deleteRecruiterById(Long id);
	
	public List<Recruiter> findByCompanyName(String companyName);
	
	public  List<Recruiter> findAllByOrderByRecruiterNameDesc();
	

}
