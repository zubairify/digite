
public class EmailValidator {

	//1- There should only 1 @ and . symbols
	//2- Min 4 chars before @
	//3- Min 3 chars between @ and .
	//4- Min 2 chars after .
	public static void main(String[] args) {
		String email = "zubair@gmail.com";
		
		int iat = email.indexOf('@');
		int idot = email.indexOf('.');
		
		if(iat == email.lastIndexOf('@') && idot == email.lastIndexOf('.') && iat > 3
				&& idot > iat + 3 && email.length() > idot + 2)
			System.out.println("Valid Email");
		else
			System.out.println("Invalid Email");
	}
}
