package com.placement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.entity.Job;
import com.placement.exceptions.DataNotFoundException;
import com.placement.repository.JobsRepository;

@Service
public class JobServiceImpl implements JobService {

	JobsRepository jobRepo;

	@Autowired
	public JobServiceImpl(JobsRepository jobRepo) {
		this.jobRepo = jobRepo;
	}

	@Override
	public Job saveOrUpdate(Job jobs) {
		Job job = jobRepo.save(jobs);
		if (job == null) {
			throw new DataNotFoundException("Something Went Wrong");
		}
		return job;
	}

	@Override
	public List<Job> findAllJobs() {
		List<Job> jobList = jobRepo.findAll();
		if (jobList.size() == 0)
			throw new DataNotFoundException("Currently list is empty !");
		return jobList;
	}

	@Override
	public Job findJobById(Long id) {
		Optional<Job> result = jobRepo.findById(id);

		Job theJob = null;
		if (!result.isPresent()) {
			throw new DataNotFoundException(" Job is not found !!!, whose id is  " + id);

		} else {
			theJob = result.get();
			return theJob;
		}
	}

	@Override
	public Job deleteJob(Long id) {
		Job theJob = findJobById(id);

		if (theJob != null)
			jobRepo.delete(theJob);
		else
			throw new DataNotFoundException("Job not found!!!");
		return theJob;
	}

	@Override
	public List<Job> findJobByRole(String role) {
		List<Job> jobs = jobRepo.findByRole(role);
//		System.err.println(jobs.size());
		if (jobs.size() == 0) {
			throw new DataNotFoundException("Currently this job is not available !!");
		}
		return jobs;
	}

	@Override
	public List<Job> findAllByStudentId(Long id) {

		List<Job> jobs = jobRepo.findAllByStudentId(id);
		if (jobs.size() > 0) {
			return jobs;
		} else
			throw new DataNotFoundException("Student is not applied any job !!!");
	}

	@Override
	public List<Job> findAllByRecruiterId(Long id) {
		List<Job> list = jobRepo.findAllByRecruiterId(id);

		if (list.size() == 0)
			throw new DataNotFoundException(" This recruiter whose id is " + id + " didn't post any jobs");
		return list;
	}

}
