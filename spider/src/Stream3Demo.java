import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream3Demo {

	public static void main(String[] args) {
		Map<String, String> people = new HashMap<>();
		people.put("Polo", "Pune");
		people.put("Mili", "Mumbai");
		people.put("Ben", "Bangalore");
		
		people.values().stream().forEach(System.out::println);
		List<String> cities = people.values().stream().map(
				s -> s.toUpperCase()).sorted().collect(Collectors.toList());
		cities.forEach(System.out::println);
		
		Map<String, List<String>> contacts = new HashMap<>();
		contacts.put("Frudo", Arrays.asList("1212-3232", "55566-7878"));
		contacts.put("Wilson", Arrays.asList("9292-8787", "4545-3232"));
		contacts.put("Jacob", Arrays.asList("2020-7171", "6969-4242"));
		
		contacts.values().stream().flatMap(Collection::stream).forEach(System.out::println);
	}
}
