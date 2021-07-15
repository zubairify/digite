import java.sql.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateDemo {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.now();
		System.out.println(date1);
		
		LocalDate date2 = LocalDate.of(2020, 06, 10);
		System.out.println(date2);
		
		LocalDate date3 = LocalDate.parse("2019-05-29");
		System.out.println(date3);
		
		LocalDate tomorrow = date1.plusDays(1);
		System.out.println(tomorrow);
		
		LocalDate prevMon = date2.minus(1, ChronoUnit.MONTHS);
		System.out.println(prevMon);
		
		DayOfWeek sunday = LocalDate.parse("2021-07-11").getDayOfWeek();
		System.out.println(sunday);
		
		System.out.println(date2.isLeapYear());
		
		Date dt = Date.valueOf(date3);
		System.out.println(dt);
	}
}
