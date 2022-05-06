package com.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	private long sid;
	private String name;
	private String fathersname;
	private String address;
	private float fee;
	private int mobileno;
	

	public Student() {
	}

	protected Student(long sid, String name, String fathersname, String address, float fee,int mobileno) {
		super();
		this.sid = sid;
		this.name = name;
		this.fathersname = fathersname;
		this.address = address;
		this.fee = fee;
		this.mobileno=mobileno;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	public long getId() {
		return sid;
	}

	public void setId(long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathersname() {
		return fathersname;
	}

	public void setFathersname(String fathersname) {
		this.fathersname = fathersname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	
	
}
