
public class GenericChild<Z, Y> extends GenericDemo<Z> {
	private Y temp;

	public GenericChild(Z data, Y temp) {
		super(data);
		this.temp = temp;
	}

	public Y getTemp() {
		return temp;
	}

	public void setTemp(Y temp) {
		this.temp = temp;
	}
	
	public static void main(String[] args) {
		GenericChild<String, Integer> c1 = new GenericChild<String, Integer>("Hello", 100);
		System.out.println(c1.getTemp());
		System.out.println(c1.getData());
	}
}
