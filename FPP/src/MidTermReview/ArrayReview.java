package MidTermReview;

import java.util.Arrays;

public class ArrayReview {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        for (int i: arr) {
            System.out.println("Before add: " + i); // 1,2,3,4,5
            i += 2;
            System.out.println("After add: " + i); // 3,4,5,6,7
        }

        // print out array
        Arrays.toString(arr);
    }
}
