package Prob5;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;


public class UsingLambdaExpression {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		list.forEach(item -> System.out.println(item.toUpperCase()));
	}
}