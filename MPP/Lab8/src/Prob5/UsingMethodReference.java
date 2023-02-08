package Prob5;

import java.util.Arrays;
import java.util.List;


public class UsingMethodReference {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");

		list.stream().map(String::toUpperCase).forEach(System.out::println);

	}
	

	
	
}