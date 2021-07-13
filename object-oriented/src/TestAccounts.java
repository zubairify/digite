import com.digite.bank.AccountFactory;
import com.digite.bank.BalanceException;
import com.digite.bank.Bank;

public class TestAccounts {

	public static void main(String[] args) {
		// Create AccountFactory class for providing respective objects
		Bank s1 = AccountFactory.openAccount("Savings", "Polo");
		
		try {
			s1.withdraw(1500);
		} catch (BalanceException e) {
//			e.printStackTrace(); // For Developers to troubleshoot the problem
//			System.out.println(e.toString()); // For logging to audit system behaviour
			System.out.println(e.getMessage());	// For user information
		}
		
	}
}
