package Assgnment_Lession_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Les_2_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> fortune = new ArrayList<String>();
        fortune.add("You will get 4.0 GPA this semester.");
        fortune.add("Happiness is programming.");
        fortune.add("Satisfaction follows hard work");
        fortune.add("Patience is virtue");
        fortune.add("Work at Google");
        fortune.add("Work at Meta");
        fortune.add("Work at Netflix");
        fortune.add("Work at Tesla");
        fortune.add("Travel to all state of US");
        fortune.add("Enjoy the good life");

        System.out.println("Welcome to fortune telling program");
        while (true) {
            System.out.println("Fortune (Y/N)?");
            String res = sc.nextLine();
            if (res.equals("N") || res.equals("n")) {
                return;
            } else {
                Random rd = new Random();
                int random = rd.nextInt(10);
                System.out.println(fortune.get(random));

            }
        }
    }
}
