package com.Beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accountant {
	private Long aid;
	private String username;
	private String password;
	private String branch;
	public String dob;
	public String doj;
	private float salary;
	
	public Accountant() {
	}

	protected Accountant(Long aid, String username, String password,String doj, String dob, String branch, float salary) {
		super();
		this.aid = aid;
		this.username = username;
		this.password = password;
		this.branch = branch;
		this.doj=doj;
		this.dob=dob;
		this.salary = salary;
		
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	

	public Long getId() {
		return aid;
	}

	public void setId(Long aid) {
		this.aid = aid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getdob() {
		return dob;
	}
    public void setdob(String dob) {
    	this.dob=dob;
    }
    public String getdoj() {
		return doj;
    }
    public void setdoj(String doj) {
    	this.doj=doj;
    }
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
