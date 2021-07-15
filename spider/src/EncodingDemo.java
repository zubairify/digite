import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncodingDemo {

	public static void main(String[] args) {
		String password = "P@ssw0rd";
		System.out.println("Original Password: " + password);
		
		Encoder encoder = Base64.getEncoder();
		byte[] bytes = encoder.encode(password.getBytes());
		System.out.println("Encoded Password: " + new String(bytes));
		
		Decoder decoder = Base64.getDecoder();
		byte[] debytes = decoder.decode(bytes);
		System.out.println("Decoded Password: " + new String(debytes));
	}
}
