import com.digite.lib.Book;
import com.digite.lib.Member;

public class TestLibrary {

	public static void main(String[] args) {
		Book b1 = new Book("The Alchemist");
		Member m1 = new Member("Polo");
		
		Book b2 = new Book("The Prophet");
		Member m2 = new Member("Mili");
		
		b1.status();
		m1.status();
		
		b1.issueBook(m1);
		
		b1.status();
		m1.status();
		
		b1.issueBook(m2);
		b2.issueBook(m1);
		
		b2.returnBook(m1);
		b1.returnBook(m2);
		
		b2.issueBook(m2);
		b1.returnBook(m2);
	}
}
