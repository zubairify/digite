
public class Demo {
	private Object data;

	public Demo(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static void main(String[] args) {
		Demo d1 = new Demo(100);
		d1.setData("Hello");
		System.out.println(d1.getData());
		
		Demo d2 = new Demo("Hola");
		d2.setData(new Person("Lili", 19));
		System.out.println(d2.getData());
	}
}
