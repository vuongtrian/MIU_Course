package lesson11.labs.prob4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for(Number num : nums) s += num.doubleValue();
        return s;
    }

    public static void main(String[] args) {
//        List<Integer> ints = new ArrayList<>();
//        ints.add(1);
//        ints.add(2);
//        List<? extends Number> nums = ints;
//        double dbl = sum(nums);
//        nums.add(3.14);

/*
*   a. Is there a compiler error in the following lines of code? If so, where?
* Error at nums.add(3.14) because list nums can allow anytype which inheritance Number.
* So we can't pass Double to nums
* */

//        List<Object> objs = new ArrayList<>();
//        objs.add(1);
//        objs.add("two");
//        List<? super Integer> ints = objs;
//        ints.add(3);
//        double dbl = sum(ints);

        /*
        * b. Is there a compiler error in the following lines of code? If so, where?
        * Error at double dbl = sum(ints)
        * because sum method receive Collection of type which is inheritance Number.
        * But ints can be Object
        * */
    }
}
