import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerDemo {
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = console.nextLine();
		
		System.out.print("Enter age: ");
		int age = console.nextInt();
		
		System.out.println("Name: " + name + "\tAge: " + age);
		
		String path = "/Volumes/KB/Dump/pers.txt";
		try {
			BufferedWriter writer = new BufferedWriter(
									new FileWriter(path, true));
			
			writer.write("Name: " + name + "\tAge: " + age);
			writer.newLine();

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
