package lesson9.labs.prob2;

import java.util.stream.IntStream;;

public class Main {
    public static void main(String[] args) {
        int[] myInt = {2,5,1,7,9};
        int max = IntStream.of(myInt).max().getAsInt();
        int min = IntStream.of(myInt).min().getAsInt();
        System.out.println("Min: " + min + " - Max: " + max);
    }
}
