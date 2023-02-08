package Prob6;


import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Examples {


    //type: Class::instanceMethod
    Function<String, String> upper1 = (String x) -> x.toUpperCase();
    Function<String, String> upper2 = String::toUpperCase;
    Function<Employee, String> getName = Employee::getName;

    BiConsumer<Employee, String> setName = Employee::setName;

    BiFunction<String, String, Integer> compare = String::compareTo;
    Comparator<String> compareFunction = String::compareTo;
    BiFunction<Integer, Integer, Double> pow = Math::pow;
    Function<Apple, Double> getWeight = Apple::getWeight;
    Function<String, Integer> f = Integer::parseInt;
    EmployeeNameComparator emp = new EmployeeNameComparator();
    BiFunction<Employee, Employee, Integer> compareEmployee = emp::compare;

    public void evaluator() {
        System.out.println(upper2.apply("hello"));
    }

    public static void main(String[] args) {
        Examples e = new Examples();
        e.evaluator();

    }

    class Employee {
        private String name;

        public Employee(String name) {
            this.name = name;// TODO Auto-generated constructor stub
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Apple {
        private Double weight;

        public Double getWeight() {
            return weight;
        }

        public void setWeight(Double weight) {
            this.weight = weight;
        }
    }

    class EmployeeNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getName().compareTo(e2.getName());
        }
    }
}
