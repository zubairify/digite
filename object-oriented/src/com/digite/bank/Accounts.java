package com.digite.bank;

import java.util.ArrayList;

public abstract class Accounts implements Bank {
	private int acntNo;
	private String holder;
	protected double balance;
	protected ArrayList<Transaction> txns;

	private static int counter = INIT_ACCOUNT_NO;
		
	public Accounts() {
	}

	public Accounts(String holder, double balance) {
		this.acntNo = counter ++;
		this.holder = holder;
		this.balance = balance;
		
		txns = new ArrayList<Transaction>();
		txns.add(new Transaction("OB", balance, balance));
	}
	
	public void summary() {
		System.out.println("A/C No: " + acntNo);
		System.out.println("Holder: " + holder);
		System.out.println("Balance: " + balance);
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
		txns.add(new Transaction("Cr", amount, balance));
	}
	
	public void statement() {
		System.out.println("Statement of A/C: " + acntNo);
		System.out.println("Type\tAmount\tBalance");
		for (Transaction t : txns) {
			t.print();
		}
	}
}
