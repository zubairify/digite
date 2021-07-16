import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialDemo {
	
	public static void main(String[] args) throws Exception {
		String path = "/Volumes/KB/Dump/pers.dat";
		ObjectOutputStream ostream = null;
		ObjectInputStream istream = null;
		
		Person p = new Person("Polo", 21);
		
		// Serialization code
		FileOutputStream fos = new FileOutputStream(path);
		ostream = new ObjectOutputStream(fos);
		ostream.writeObject(p);
		System.out.println("Object serialized..");
		ostream.close();
		
		// Deserialization code
		FileInputStream fis = new FileInputStream(path);
		istream = new ObjectInputStream(fis);
		Object obj = istream.readObject();
		System.out.println("Object deserialized");
		System.out.println(obj);
		istream.close();
	}
}
