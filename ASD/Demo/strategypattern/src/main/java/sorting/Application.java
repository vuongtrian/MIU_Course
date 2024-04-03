package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> fruits = Arrays.asList(
		        "watermelon",
		        "apple",
		        "pear");
		 
		    Collections.sort(fruits, new AlphabeticalComparator());
		    // will print [apple, pear, watermelon]
		    System.out.println(fruits);
		 
		    Collections.sort(fruits, new ByLengthComparator());
		    // will print [pear, apple, watermelon]
		    System.out.println(fruits);
	}

}
