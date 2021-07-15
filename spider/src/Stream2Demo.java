import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Stream2Demo {

	public static void main(String[] args) {
		String[] star = {"Cherry","Mango","Grapes","Apple","Papaya","Banana","Strawberry","Kiwi","Fig"};
		List<String> basket = Arrays.asList(star);
		basket.forEach(System.out::println);
		
		basket.stream().sorted().forEach(System.out::println);
		
		basket.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
		
		basket.stream().filter(str -> str.contains("a")).forEach(System.out::println);
		
		Stream.of("John", "Sean", "Anna", "Bret").sorted().forEach(System.out::println);
		
		System.out.println(Arrays.stream(star).filter(s -> s.contains("p")).count());
	}
}
