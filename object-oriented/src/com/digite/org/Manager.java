package com.digite.org;

public class Manager extends Employee {
	private double commission;

	public Manager() {
	}

	public Manager(String empName, double salary, double commission) {
		// Calls parameterised constructor of super class with matching signature
		super(empName, salary);
		this.commission = commission;
	}

	// Overriding methods of super class Employee
	@Override
	public void payslip() {
		super.payslip();	// calls the super class' payslip implementation
		System.out.println("Commission: " + commission);
	}

	@Override
	public double getSalary() {
		return super.getSalary() + commission;
	}
	
}
