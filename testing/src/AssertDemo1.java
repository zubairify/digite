
public class AssertDemo1 {

	public static void main(String[] args) {
		int age = 19;
		assert age >= 18 : "Not valid";
		
		System.out.println("Age: " + age);
	}
}
