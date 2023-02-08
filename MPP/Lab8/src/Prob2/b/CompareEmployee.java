package Prob2.b;

import java.util.Comparator;

public class CompareEmployee implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        int result = e1.name.compareTo(e2.name);
        if(result == 0) {
            result = Integer.compare(e1.salary, e2.salary);
        }
        return result;
    }
}
