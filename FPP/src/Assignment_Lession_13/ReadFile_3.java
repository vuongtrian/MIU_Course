package Assignment_Lession_13;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Arrays;

public class ReadFile_3 {

    public static void main(String[] args) {
        String str = readBuffer("ReadFile_3.txt");
        String[] arr = str.split("\n");
        System.out.println(Arrays.toString(arr));
        double sum = 0;
        for (String i: arr) {
            sum += Double.valueOf(i);
        }
        double average = sum / arr.length;
        System.out.println("Average: " + average);
    }

    public static String readBuffer(String file) {
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
