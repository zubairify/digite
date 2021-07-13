package com.digite.bank;

public interface Bank {
	//Application Constants
	int INIT_ACCOUNT_NO=11001;
	double MIN_SAVINGS_BALANCE = 1000;
	double INIT_CURRENT_BALANCE = 5000;
	double MIN_CURRENT_BALANCE = 0;
	double OVERDRAFT_LIMIT = 10000;
	
	void deposit(double amount);
	void withdraw(double amount) throws BalanceException;
	void summary();
	void statement();
	double getBalance();
}
