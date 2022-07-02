package com.placement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "pms_recruiter")
public class Recruiter {
	
	@Id
	@GeneratedValue(generator = "recuriterId" , strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "recuriterId",initialValue = 100)
	@Column(name = "recuriterId")
	private long id;
	
	@NotBlank(message = "companyName is required !!")
	@Column(name = "companyName")
	private String companyName;
	
	@URL
	private String companyUrl;
	
	@NotBlank(message = "Phone number must be required. !!")
	@Size(min = 10, max = 10, message = "Invalid phone number!!")
	private String contactNumber;
	
	@NotBlank(message = "Email must be required !!")
	@Email
	private String email;
	
	@Column(unique = true)
	@NotBlank(message = "Recuriter name must be required !!")
	@Size(min = 3, max = 10, message = "Character must be in between 3-10 !!")
	private String recruiterName;
	
	@Size(min = 4, max = 10, message = "Password length must be 4 to 10. !!")
	private String password;
	
	
//	one recruiter can post multiple jobs
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recruiter")
	List<Job> jobList = new ArrayList<>(); 

	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", companyName=" + companyName + ", companyUrl=" + companyUrl
				+ ", contactNumber=" + contactNumber + ", email=" + email + ", recruiterName=" + recruiterName
				+ ", password=" + password + "]";
	}
	
	

}
