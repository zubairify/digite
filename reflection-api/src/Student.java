
@Depressed(level = 10)
@Stream(topic = "Medical")
public class Student {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
	@Deprecated
	public void print() {
		System.out.println("Student Name: " + name);
	}
}
