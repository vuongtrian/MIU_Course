package Prob2.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	
	public void sort(List<Employee> emps, final SortMethod method) {
		class EmployeeComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee e1, Employee e2) {
				if(method == SortMethod.BYNAME) {
					return e1.name.compareTo(e2.name);
				} else {
					if(e1.salary == e2.salary) return 0;
					else if(e1.salary < e2.salary) return -1;
					else return 1;
				}
			}
		}
		Collections.sort(emps, new EmployeeComparator());
	}
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Andy", 70000));
		emps.add(new Employee("Andy", 70000));
//		EmployeeInfo ei = new EmployeeInfo();
//		ei.sort(emps, SortMethod.BYNAME);
//		System.out.println(emps);
//		//same instance
//		ei.sort(emps, SortMethod.BYSALARY);
//		System.out.println(emps);

		System.out.println(emps.get(2).equals(emps.get(3)));
		CompareEmployee compareEmployee = new CompareEmployee();
		System.out.println(compareEmployee.compare(emps.get(2), emps.get(3)));
	}
}
