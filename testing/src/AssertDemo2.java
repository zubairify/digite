
public class AssertDemo2 {
	
	public static void main(String[] args) {
		
		assert args.length == 3 : "Mandatory to pass 3 arguments";
		
		for (String arg : args) 
			System.out.println(arg);
	}

}
