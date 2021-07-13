import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAccount {
	private Account acnt;
	
	@BeforeEach
	public void init() {
		acnt = new Account(1000);
	}
	
	@Test
	public void testWithdraw() throws BalanceException {
		assertEquals(500, acnt.withdraw(500));
	}
	
	@Test
	public void testInvalidWithdraw() {
		
	}
	
	@Test
	public void testNegativeWithdraw() {
		
	}
	
}
