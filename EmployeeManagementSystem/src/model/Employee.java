package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	String userId;
	String department;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String userId, String department) {
		super();
		this.userId = userId;
		this.department = department;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", department=" + department + "]";
	}

}
