package Assignment_Lession_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Les_2_9 {
    public static List<String> condons (String str) {
        int start = 0;
        int end = 3;
        List<String> res = new ArrayList<>();

        while (end <= str.length()) {
            res.add(str.substring(start,end));
            start = end;
            end += 3;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a string: ");
            String input = sc.nextLine();
            if (input.isEmpty() || input.isBlank()) {
                return;
            } else {
                List<String> res = condons(input);
                System.out.println("------Output-----");
                if (res.isEmpty()) {
                    System.out.println("Empty");
                }
                for (String value : res) {
                    System.out.println(value);
                }
            }
        }
    }
}
