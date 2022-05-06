package com.Beans;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Payment {
	private Long pid;
	private String name;
	private String date;
	private double balance;
	private String mobileno;

	public Payment() {
	}
	
	
	public Payment(Long pid, String name, String date, double balance, String mobileno) {
		super();
		this.pid = pid;
		this.name = name;
		this.date = date;
		this.balance = balance;
		this.mobileno = mobileno;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public Long getId() {
		return pid;
	}


	public void setId(Long pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
}

	