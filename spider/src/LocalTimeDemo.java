import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {

	public static void main(String[] args) {
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		LocalTime sixThirty = LocalTime.parse("06:30");
		System.out.println(sixThirty);
		
		LocalTime twoForty = LocalTime.of(02, 40);
		System.out.println(twoForty);
		
		LocalTime fourForty = twoForty.plus(2, ChronoUnit.HOURS);
		System.out.println(fourForty);
		
		System.out.println(twoForty.getHour());
		System.out.println(LocalTime.MAX);
	}
}
