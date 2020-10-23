package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Testing_head {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String msg;

	public Testing_head() {
		super();
		// TODO Auto-generated constructor stub
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

	public Testing_head(int id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Testing_head [id=" + id + ", msg=" + msg + "]";
	}

	

}
