package lesson11.labs.prob5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4,3,6,2,7);
        Integer res = secondSmallest(list);
        System.out.println(res);
    }

    public static <T extends Comparable<T>> T secondSmallest (List<T> list) {
        T first = list.get(0);
        T second = list.get(1);
        if(first.compareTo(second) > 0) { // first > second
            T temp = first;
            first = second;
            second = temp;
        }
        for (int i = 2; i < list.size(); i++) {
            T cur = list.get(i);
            if(cur.compareTo(first) < 0) { // cur < first
                second = first;
                first = cur;
            } else if(cur.compareTo(second) < 0 && cur != first) {
                second = cur;
            }
        }
        return second;
    }
}
