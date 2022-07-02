package com.placement.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pms_jobs")
public class Job {
	@Id
	@GeneratedValue(generator = "jobid", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "jobid", initialValue = 1000)
	@Column(name = "job_id")
	private long id;

	
	@Column(name = "companyname")
	@NotNull(message = "Company name must be required !!!")
	@Size(min = 3, message = "Name of the company must have 3 or more character !!!")
	private String companyName;
	
	@Size(min = 3, message = "Name of the location must have 3 or more character !!!")
	private String location;
	
	@Size(min = 3, message = "Name of the Role must have 3 or more character !!!")
	private String role;
	
	@Min(value = 10000, message = "Salary must be greate than 10000")
	@Max(value = 10000000, message = "Salary must be less than 10000000")
	private Long salary;
	
//	Many students can apply for one job - for that we used many to one association 
	@ManyToOne
	private Student student;
	
//	Many Job posted by only one recruiter.
	@ManyToOne
	private Recruiter  recruiter; 

	public Job() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyName;
	}

	public void setCompanyname(String companyname) {
		this.companyName = companyname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Recruiter getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Recruiter recruiter) {
		this.recruiter = recruiter;
	}

	@Override
	public String toString() {
		return "Jobs [id=" + id + ", companyname=" + companyName + ", location=" + location + ", role=" + role
				+ ", salary=" + salary + ", student=" + student + "]";
	}

	
}
