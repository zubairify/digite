package com.digite.org;

public abstract class Employee {
	private int empNo;
	private String empName;
	private double salary;
	
	private static int counter;
	
	// Static initialiser block, executes at class loading, acts as constructor for static member
	static {	
		System.out.println("Employee class loaded...");
		counter = 101;
	}
	
	public Employee() {
	}

	public Employee(String empName, double salary) {
		this.empNo = counter ++;
		this.empName = empName;
		this.salary = salary;
	}
	
	public void payslip() {
		System.out.println("Emp No: " + empNo);
		System.out.println("Emp Name: " + empName);
		System.out.println("Salary: " + salary);
	}

	public double getSalary() {
		return salary;
	}
}
