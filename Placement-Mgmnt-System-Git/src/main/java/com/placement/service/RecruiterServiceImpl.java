package com.placement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.placement.entity.Recruiter;
import com.placement.exceptions.NotFoundException;
import com.placement.repository.RecruiterRepository;

@Service
public class RecruiterServiceImpl implements RecruiterService {

	RecruiterRepository recruiterRepository;

	@Autowired
	public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
		this.recruiterRepository = recruiterRepository;
	}

	@Override
	public Recruiter saveOrUpdate(Recruiter recruiter) {
//		Recruiter  recruiters = recruiterRepository.save(recruiter);
//		return recruiters;

		Recruiter result = recruiterRepository.findByRecruiterName(recruiter.getRecruiterName());
		if (result != null) {
			throw new NotFoundException("Recruiter-name is already registerd, Try with different name ?");
		} else {
			Recruiter recruiters = recruiterRepository.save(recruiter);
			return recruiters;
		}
	}

	@Override
	public Recruiter findRecruiterById(Long id) {
		Optional<Recruiter> result = recruiterRepository.findById(id);

		Recruiter theRecruiter = null;
		if (result != null) {
			theRecruiter = result.get();
			return theRecruiter;
		} else
			throw new NotFoundException("Recruiter is not available whose id is " + id);

	}

	@Override
	public Recruiter deleteRecruiterById(Long id) {
		Recruiter theRecruiter = findRecruiterById(id);

		if (theRecruiter != null) {
			recruiterRepository.delete(theRecruiter);
			return theRecruiter;
		} else
			throw new NotFoundException("Recruiter is not available whose id is " + id);
	}

	@Override
	public List<Recruiter> findByCompanyName(String companyName) {
		List<Recruiter> recruiters = recruiterRepository.findByCompanyName(companyName);
		if (recruiters.size() == 0) {
			throw new NotFoundException(companyName + " is not available in our list !!");
		}
		return recruiters;
	}

	@Override
	public List<Recruiter> findAllRecruiters() {
		List<Recruiter> recruiters = recruiterRepository.findAll();
		if (recruiters.size() == 0) {
			throw new NotFoundException("List is empty !!");
		}
		return recruiters;
	}

	@Override
	public List<Recruiter> findAllByOrderByRecruiterNameDesc() {
		List<Recruiter> recruiters = recruiterRepository.findAllByOrderByRecruiterNameDesc();

		if (recruiters.size() == 0) {
			throw new NotFoundException("List is empty !!");
		}
		return recruiters;
	}

	@Override
	public Recruiter findByRecruiterName(String name) {
		Recruiter recruiter = recruiterRepository.findByRecruiterName(name);
		if (recruiter == null) {
			throw new NotFoundException("Recruiter not found !!!");
		}
		return recruiter;
	}

}
