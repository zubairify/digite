import com.digite.stock.Broker;
import com.digite.stock.Exchange;
import com.digite.stock.Holder;
import com.digite.stock.StockSingleton;

public class TestStock {

	public static void main(String[] args) {
		Holder h = StockSingleton.getStock();
		
		Broker b = StockSingleton.getStock();
		
		Exchange x = StockSingleton.getStock();
		
		System.out.println(h == b);
		System.out.println(b == x);
	}
}
