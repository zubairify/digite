
public class GreetingDemo {
	
	public static void main(String[] args) {
		Greeting g1 = () -> "Hello World";
		System.out.println(g1.sayHello());
		System.out.println(g1.sayBye());
		
		Greeting g2 = () -> {
			String msg = "Bojour le Monde";
			return msg;
		};
		System.out.println(g2.sayHello());
		System.out.println(g2.sayBye());
		
		Greeting.demo();
	}
}
