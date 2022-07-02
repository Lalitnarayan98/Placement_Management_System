package com.placement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "psm_student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private Long id;
	
	@Column(unique = true)
	@NotBlank(message = "username must be required")
	@Size(min = 3, max = 10, message = "Username consists of atleast 3 characters !!!")
	private String username;
	
	@NotBlank(message = "Firstname must be required")
	private String firstname;
	
	@NotBlank(message = "Lastname must be required")
	private String lastname;
	
	@NotBlank
	@Email
	private String email;
	
	@Size(min = 4, max = 10, message = "Password length must be 4 to 10.")
	private String password;
	
	@NotBlank(message = "Phone number must be required.")
	@Pattern(regexp="(^$|[0-9]{10})",message = "Invalid Number") 
	private String phoneNumber;
	
	private String highestQualification;
	private String gender;
	private String linkedInUrl;
	private boolean enabled = true;

//	One Student can apply for many jobs- for that we used one to many associations
	@JsonIgnore  // It will ignore serialization and deserialization functionality
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
	private Set<Job> jobs ;

	public Student() {

	}
	

	public Student(Long id, String username, String firstname, String lastname, String email, String password,
			String phoneNumber, String highestQualification, String gender, String linkedInUrl, boolean enabled,
			Set<Job> jobs) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.highestQualification = highestQualification;
		this.gender = gender;
		this.linkedInUrl = linkedInUrl;
		this.enabled = enabled;
		this.jobs = jobs;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", highestQualification=" + highestQualification + ", gender=" + gender + ", linkedInUrl="
				+ linkedInUrl + ", enabled=" + enabled + ", jobs=" + jobs + "]";
	}

	

}
