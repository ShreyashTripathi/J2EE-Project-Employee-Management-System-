package model;

import java.sql.Connection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_user")
public class User {
	
	@Id
	@Column(name = "USER_ID",unique=true,columnDefinition="VARCHAR(64)")
	String userId;
	String employeeName;
    String fatherName;
    String gender;
    String dateOfBirth;
    String collegeName;
    String experience;
    String prevSalary;
    String specialization;
    String designation;
    String contactNo;
    String email;
    String address1;
    String address2;
    String city;
    String postalCode;
    String passWord;
    String department;
    
    public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String employeeName, String fatherName, String gender, String dateOfBirth,
			String collegeName, String experience, String prevSalary, String specialization, String designation,
			String contactNo, String email, String address1, String address2, String city, String postalCode,
			String passWord, String department) {
		super();
		this.userId = userId;
		this.employeeName = employeeName;
		this.fatherName = fatherName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.collegeName = collegeName;
		this.experience = experience;
		this.prevSalary = prevSalary;
		this.specialization = specialization;
		this.designation = designation;
		this.contactNo = contactNo;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postalCode = postalCode;
		this.passWord = passWord;
		this.department = department;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPrevSalary() {
		return prevSalary;
	}

	public void setPrevSalary(String prevSalary) {
		this.prevSalary = prevSalary;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", employeeName=" + employeeName + ", fatherName=" + fatherName + ", gender="
				+ gender + ", dateOfBirth=" + dateOfBirth + ", collegeName=" + collegeName + ", experience="
				+ experience + ", prevSalary=" + prevSalary + ", specialization=" + specialization + ", designation="
				+ designation + ", contactNo=" + contactNo + ", email=" + email + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", postalCode=" + postalCode + ", passWord=" + passWord
				+ ", department=" + department + "]";
	}
   
    
	
   
}
