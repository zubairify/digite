
public class Customer {
	private int custId;
	private String custName;
	private double creditLimit;
	
	public Customer() {
	}
	
	public Customer(int custId, String custName, double creditLimit) {
		this.custId = custId;
		this.custName = custName;
		this.creditLimit = creditLimit;
	}
	
	public void display() {
		System.out.println("Cust Id: " + custId);
		System.out.println("Cust Name: " + custName);
		System.out.println("Credit Limit: " + creditLimit);
	}
	
	public static void main(String[] args) {
		Customer c1 = new Customer(101, "Ken", 3000);
		c1.display();
	}
}
