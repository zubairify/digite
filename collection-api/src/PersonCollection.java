import java.util.TreeSet;

public class PersonCollection {

	public static void main(String[] args) {
		PersonAgeComparator pac = new PersonAgeComparator();
		
		TreeSet<Person> tree = new TreeSet<Person>();
		tree.add(new Person("Mili", 20));
		tree.add(new Person("Lili", 19));
		tree.add(new Person("Polo", 21));
		
		for (Person p : tree) 
			System.out.println(p);
	}
}
