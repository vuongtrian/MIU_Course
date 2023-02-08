package lesson11.labs.prob1;

import java.util.ArrayList;
import java.util.List;

public class prob1_a {
//    public static void main(String[] args) {
//        List<Integer> ints = new ArrayList<>();
//        ints.add(1);
//        ints.add(2);
//        List<Number> nums = ints;
//        nums.add(3.14);
//    }

    /*
    * Error: List<Number> nums = ints
    * Because List is generic class and it can't be covariant
    * Number is supper tyoe and Integer is sub type, so we can't assign Integer tyoe to Number type
    * */
}
