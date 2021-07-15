import java.util.Vector;

public class TraversingCollectionDemo {

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add("Apple");
		v.add("Banana");
		v.add("Cherry");
		
		v.forEach(System.out::println);
	}
}
