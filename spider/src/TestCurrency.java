import static com.digite.cc.Currency.*;

public class TestCurrency {

	public static void main(String[] args) {
		double dtor = convert(USD, INR, 100);
		System.out.println(dtor);
		
		System.out.println(convert(INR, USD, 10000));
		
		System.out.println(convert(AED, INR, 1000));
	}
}
