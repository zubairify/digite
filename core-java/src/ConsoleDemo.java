import java.util.Scanner;

public class ConsoleDemo {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter Name: ");
		String name = console.next();
		
		String nameRegex = "[A-Z][a-z]{3,}";
		if(name.matches(nameRegex))
			System.out.println("Name: " + name);
		else
			System.out.println("Invalid name");
		
		System.out.print("Enter Mobile: ");
		String mobile = console.next();
		
		String mobRegex = "[7-9][0-9]{9}";
		assert mobile.matches(mobRegex) : "Invalid Mobile No";
		System.out.println("Mobile No: " + mobile);
	}
}
