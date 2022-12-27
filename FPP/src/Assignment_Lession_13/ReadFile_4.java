package Assignment_Lession_13;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadFile_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean temp = true;
        String ad = "";

        while (temp) {
            System.out.println("Write our advice. Otherwise press 0 to stop");
            String str = sc.nextLine();
            if(str.equals("0")) {
                temp = false;
            } else {
                ad += str + "\n";
            }
        }
        BufferedWriter(ad, "ReadFile_4");
        System.out.println("The advice are below: ");
        System.out.println(ReadBuffer("ReadFile_4"));;

    }

    static void BufferedWriter(String str, String file) {
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(str);
            buffer.close();
            writer.close();
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println(e);
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
