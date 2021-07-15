
@FunctionalInterface
public interface Greeting {
	String sayHello();	// Supplier
	
	default String sayBye() {
		return "Goodbye";
	}
	
	static void demo() {
		System.out.println("Whatever");
	}
}
