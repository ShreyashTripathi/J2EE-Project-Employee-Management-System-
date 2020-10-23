package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Dep_head {

	@Id
	String userId;
	String department;

	public Dep_head() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dep_head(String userId, String department) {
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
		return "Dep_head [userId=" + userId + ", department=" + department + "]";
	}

}
