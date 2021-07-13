package com.digite.bank;

public class Savings extends Accounts {

	public Savings() {
	}

	public Savings(String holder) {
		super(holder, MIN_SAVINGS_BALANCE);
	}

	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount < (balance - MIN_SAVINGS_BALANCE)) {
			balance -= amount;
			txns.add(new Transaction("Dr", amount, balance));
		}
		else
			throw new BalanceException("Insufficient balance!");
	}
}
