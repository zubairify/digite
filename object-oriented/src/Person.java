
public class Person implements Cloneable {
	// Attributes of a class are usually private
	private String name;
	private int age;
	
	// Constructors
	public Person() {
		// Calling another constructor on the same object with matching signature
		// AKA constructor chaining
		this("Anonymous", -1);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// Methods of a class are usually public
	public void print() {
		System.out.println("Name: " + name + "\tAge: " + age);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\tAge: " + age;
	}

	@Override
	public void finalize() throws Throwable {
		System.out.println("Person is no more!");
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person) obj;
			if(p.name.equals(this.name) && p.age == age)
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		Person p1 = new Person("Polo", 21);
		
		Person p2 = new Person("Polo", 21);
		
		System.out.println(p1.equals(p2));
	}
}
