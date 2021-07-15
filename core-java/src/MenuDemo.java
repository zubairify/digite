import java.util.Scanner;

public class MenuDemo {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		while (true) {
			System.out.println("1-Add\n2-View\n3-Delete\n4-Exit");
			System.out.print("Choice: ");
			int option = console.nextInt();
			switch (option) {
			case 1:
				System.out.println("Add selected");
				break;
			case 2:
				System.out.println("View selected");
				break;
			case 3:
				System.out.println("Delete selected");
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid option");
			}
		}
	}
}
