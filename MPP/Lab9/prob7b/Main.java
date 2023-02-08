package lesson9.labs.prob7b;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
				          new Employee("John", "Sims", 110000),
				          new Employee("Joe", "Stevens", 200000),
		                  new Employee("Andrew", "Reardon", 80000),
		                  new Employee("Joe", "Cummings", 760000),
		                  new Employee("Steven", "Walters", 135000),
		                  new Employee("Thomas", "Blake", 111000),
		                  new Employee("Alice", "Richards", 101000),
		                  new Employee("Donald", "Trump", 100000));

		List<String> letters = IntStream.rangeClosed('N', 'Z').mapToObj(var -> "" + (char) var).collect(Collectors.toList());
		for (String s : letters) {
			LambdaLibrary.SEARCH_BY_LASTNAME_AND_SALARY.apply(list, s, 100000).forEach(System.out::println);
		}
	}


}

class LambdaLibrary {
	public static final TriFunction<List<Employee>, String, Integer, List<String>>
			SEARCH_BY_LASTNAME_AND_SALARY = (list, search, salary) -> list.stream()
			.filter(a -> a.getSalary() > salary)
			.filter(a -> a.getLastName().startsWith(search))
			.map(a -> a.getFirstName() + " " + a.getLastName())
			.sorted()
			.collect(Collectors.toList());
}



