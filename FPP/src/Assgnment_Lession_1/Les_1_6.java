package Assgnment_Lession_1;

import java.util.Scanner;

public class Les_1_6 {

    public static String[] input () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input 3 names");
        String[] arr = new String[3];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("Name " + (i+1) + ": ");
            arr[i] = sc.nextLine();
        }

        return arr;
    }

    public static String revertStr (String str) {
        String res = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            res += c;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] data = input();

       for (int i = 0; i < data.length; i++) {
           String temp = revertStr(data[i]);
           data[i] = temp;
       }

        for (String str: data) {
            System.out.println(str);
        }


    }
}
