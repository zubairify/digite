import com.digite.convert.CurrencyConverter;
import com.digite.convert.INR;
import com.digite.convert.USD;

public class TestCurrencyConverter {

	public static void main(String[] args) {
		USD usd = new USD();
		INR inr = new INR();
		CurrencyConverter cc = new CurrencyConverter();
		System.out.println(cc.convert(usd, inr, 100));
	}
}
