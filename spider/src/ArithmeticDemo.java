
public class ArithmeticDemo {

	public static void main(String[] args) {
//		Arithmetic a1 = (x) -> x * x;
//		System.out.println(a1.square(10));

		Arithmetic a2 = (x, y) -> x + y;
		System.out.println(a2.sum(10, 30));
	}
}
