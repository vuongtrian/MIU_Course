package lesson11.labs.prob1;

import java.util.ArrayList;
import java.util.List;

public class prob1_b {
//    public static void main(String[] args) {
//        List<Integer> ints = new ArrayList<>();
//        ints.add(1);
//        ints.add(2);
//        List<? extends Number> nums = ints;
//        nums.add(3.14);
//    }

    /*
    * Error at nums.add(3.14)
    * because list num reference to list Integer and this was extended Number
    * so we can't add Double to nums
    * */
}
