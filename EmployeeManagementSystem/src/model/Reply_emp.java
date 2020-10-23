package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reply_emp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String msg;
	String department;

	public Reply_emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply_emp(int id, String msg, String department) {
		super();
		this.id = id;
		this.msg = msg;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Reply_emp [id=" + id + ", msg=" + msg + ", department=" + department + "]";
	}

	
	

}
