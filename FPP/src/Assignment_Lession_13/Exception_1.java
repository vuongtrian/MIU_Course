package Assignment_Lession_13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input number from 0 - 100");
        try {
            int num = sc.nextInt();
            if(num < 0 || num > 100) {
                throw new UnsupportedOperationException("Number is invalid");
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong input. You must to input a number instead of text");
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
