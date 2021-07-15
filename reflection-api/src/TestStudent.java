
public class TestStudent {

	@SuppressWarnings({"deprecation"})
	public static void main(String[] args) {
		Student s1 = new Student("Polo");
		System.out.println(s1);
		
		s1.print();
		
		System.out.println(s1.getClass().getAnnotation(Depressed.class));
		Stream str = s1.getClass().getAnnotation(Stream.class);
		System.out.println(str.topic());
		System.out.println(str.annotationType());
	
	}
}
