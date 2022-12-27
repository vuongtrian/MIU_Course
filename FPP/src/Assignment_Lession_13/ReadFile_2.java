package Assignment_Lession_13;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class ReadFile_2 {

    public static void main(String[] args) {
        System.out.println(readBuffer("ReadFile_2.txt"));
        String str = readBuffer("ReadFile_2.txt");
        String[] arr = str.split(" ");
        int count = 0;
        for (String s : arr) {
            if(s.equals("10")) {
                count++;
            }
        }
        System.out.println("Count the total occurrences of the number '10': " + count);
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
