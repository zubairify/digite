import com.digite.org.Employee;
import com.digite.org.Executive;
import com.digite.org.Manager;

public class TestEmployee {

	public static void main(String[] args) {
		Employee e = null;
		
		Manager mgr = new Manager("Garry", 4000, 1200);
		
		e = mgr;
		e.payslip();
		
		Executive exec = new Executive("Jack", 3400, 500);
		
		showSalary(mgr);
		showSalary(exec);
	}

	private static void showSalary(Employee emp) {
		if(emp instanceof Manager)
			System.out.println("Manager Salary: " + emp.getSalary());
		else
			System.out.println("Executive Salary: " + emp.getSalary());
	}
	
//	private static void showSalary(Executive exec) {
//		System.out.println("Executive Salary: " + exec.getSalary());
//	}
//
//	private static void showSalary(Manager mgr) {
//		System.out.println("Manager Salary: " + mgr.getSalary());
//	}
}
