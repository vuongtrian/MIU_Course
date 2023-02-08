package Prob2.a;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	String name;
	int salary;
	public Employee(String n, int s) {
		this.name = n;
		this.salary = s;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("<");
		sb.append("name: ");
		sb.append(name);
		sb.append(" salary: ");
		sb.append("" + salary+">");
		return sb.toString();
		
	}

	@Override
	public int compareTo(Employee o2) {
		int result = this.name.compareTo(o2.name);
		if(result == 0) {
			result = Integer.compare(this.salary, o2.salary);
		}
		return result;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(ob.getClass() != getClass()) return false;
		Employee e = (Employee)ob;
		return e.name.equals(name) && e.salary==salary;
	}
}

