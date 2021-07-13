
class EventImpl implements Event {

	@Override
	public void doSomething() {
		System.out.println("First implementation");
	}
}

public class EventDemo {
	static class EventInnerImpl implements Event {
		@Override
		public void doSomething() {
			System.out.println("Inner implementation");
		}
	}

	public void anotherImpl() {
		class EventNestedImpl implements Event {
			@Override
			public void doSomething() {
				System.out.println("Nested implementation");
			}
		};
		new EventNestedImpl().doSomething();
	}
	
	public void oneMoreImpl() {
		Event e = new Event () {
			@Override
			public void doSomething() {
				System.out.println("Anonymous implementation");
			}
		};
		e.doSomething();
	}
	
	public void oneLastImpl() {
		Event e = () -> System.out.println("Lambda implementation");
		e.doSomething();
	}
	
	public static void main(String[] args) {
		EventImpl e1 = new EventImpl();
		e1.doSomething();
		
		EventDemo ed = new EventDemo();
//		EventInnerImpl e2 = ed.new EventInnerImpl();
		EventInnerImpl e2 = new EventDemo.EventInnerImpl();
		e2.doSomething();
		ed.anotherImpl();
		ed.oneMoreImpl();
		ed.oneLastImpl();
		
	}
}
