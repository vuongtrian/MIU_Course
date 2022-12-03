package Source_Demo;

import java.util.Scanner;

/*
* n =3
* Sum = 3 + 2 + 1
*
* n = 5
* Sum = 5 + 4 + 3 + 2 + 1
* */

public class RecursionSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Type a Number: ");
        int n = in.nextInt();

        System.out.println("Sum: " + Sum(n));

    }
    public static int Sum (int n){
        if (n == 1) {
            return 1;
        } else {
            return n + Sum(n-1);
        }
    }
}
