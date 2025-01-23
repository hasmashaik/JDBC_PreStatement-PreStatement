package com_1.employee;

public class Employeepre {
	private String empName;
	private int empId;
	private double empSalary;
	private String address;
	
	public Employeepre(String empName, int empId,double empSalary, String address ) {
		super();
		this.empName =empName;
		this.empId =empId;
		this.empSalary =empSalary;
		this.address =address;
		
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
