package Prob2A;

import java.io.FileReader;
import java.io.FileWriter;

public class Utility {
    public static String readFromFile(String file) {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fr = new FileReader(file);
            int i;
            while ((i = fr.read()) != -1) {
                sb.append((char) i);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return sb.toString();
    }

    public static void writeToFile(String file, String text) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(text);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
