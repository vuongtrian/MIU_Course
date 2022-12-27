package Assignment_Lession_13;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Arrays;

public class ReadFile_5 {
    public static void main(String[] args) {
        String str = ReadBuffer("WordBuff.txt");
        String[] arr = str.split(", ");
        int count = 0;
        for (String s: arr) {
            if(isPalindrome(s)) {
                System.out.print(s + ", ");
                count++;
            }
        }
        System.out.println("\nCount palindrome: " + count);
    }

    public static boolean isPalindrome (String input) {
        String str = input;
        String temp = "";
        while (str.length() > 0) {
            temp += str.charAt(str.length()-1);
            str = str.substring(0, str.length()-1);
        }
        if(temp.equals(input)) {
            return true;
        } else {
            return false;
        }
    }

    public static String ReadBuffer(String file) {
        String str = "";
        try {
            FileInputStream fin = new FileInputStream(file);
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i;
            while ((i = bin.read()) != -1) {
                str += (char) i;
            }
            bin.close();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return str;
    }
}
