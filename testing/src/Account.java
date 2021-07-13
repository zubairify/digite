
public class Account {
	private double balance;
	
	public Account() {
	}

	public Account(double balance) {
		this.balance = balance;
	}
	
	public double deposit(double amount) throws NumberFormatException {
		if(amount < 0)
			throw new NumberFormatException("Negative amount");
		balance += amount;
		return balance;
	}
	
	public double withdraw(double amount) throws BalanceException {
		if(amount < 0)
			throw new NumberFormatException("Negative amount");
		
		if(amount > balance) {
			throw new BalanceException("Insufficient balance");
		}
		balance -= amount;
		return balance;
	}
}
