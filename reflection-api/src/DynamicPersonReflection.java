import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DynamicPersonReflection {

	public static void main(String[] args) throws Exception {
		// Loads a Java class manually in memory
		Class pc = Class.forName("com.digite.Person");
		
		Object obj = pc.newInstance();
		System.out.println(obj);
		
		// Instantiate this class with parameterised constructor
		Constructor c = pc.getConstructor(String.class, int.class);
		Object obj2 = c.newInstance("Polo", 21);
		
		Method m = pc.getDeclaredMethod("print", null);
		m.setAccessible(true);
		
		m.invoke(obj2, null);
	}
}
