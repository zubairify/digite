import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.digite.Person;

public class PersonReflection {

	public static void main(String[] args) throws Exception {
		Person p = new Person("Polo", 21);
		System.out.println(p);
		
		Class pc = p.getClass();
		System.out.println(pc.getName());
		System.out.println(pc.getModifiers());
		System.out.println(pc.getSuperclass());
		System.out.println(pc.getInterfaces());
		
		Constructor[] constructors = pc.getConstructors();
		System.out.println("-- List of constructors");
		for (Constructor c : constructors) 
			System.out.println(c);
		
		Method[] methods = pc.getMethods();
		System.out.println("-- List of methods");
		for(Method m : methods) 
			System.out.println(m);
		
		Method[] decMethods = pc.getDeclaredMethods();
		System.out.println("-- List of declared methods");
		for(Method m : decMethods)
			System.out.println(m);
		
		Method print = pc.getDeclaredMethod("print", null);
		System.out.println(print.getName());
		print.invoke(p, null);
		
		Field[] fields = pc.getDeclaredFields();
		System.out.println("-- List of private fields");
		for(Field f : fields)
			System.out.println(f);
		
		Field name = pc.getDeclaredField("name");
		System.out.println(name.getType());
		System.out.println(name.getName());
		
	}
}
