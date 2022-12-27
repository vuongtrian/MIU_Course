package Files;

import java.io.*;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class IO {
    public static void main(String[] args) {

//        write(65);
//        write("Java#");
//        write("Testing...", "test.txt");
//
//        System.out.println(readchar("/Users/vuongtrian/Desktop/MIU_Courses/FPP/testout.txt"));
//        System.out.println(readAll("/Users/vuongtrian/Desktop/MIU_Courses/FPP/testout.txt"));
//
//        WriteBuffer("Hello", "BufferedText.txt");
        System.out.println(ReadBuffer("BufferedText.txt"));
//        System.out.println(ReadSequence("test.txt", "BufferedText.txt"));

        /*
         * Read from multiple file
         * */
//        Vector v = new Vector();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("How many files do you have?");
//        int num = sc.nextInt();
//        for (int i = 1; i <= num; i++) {
//            try {
//                System.out.println("Please Enter File NAme #" + i);
//                Scanner sc2 = new Scanner(System.in);
//                String filename = sc2.nextLine();
//
//                FileInputStream fin = new FileInputStream(filename);
//                v.add(fin);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//        Enumeration e = v.elements();
//        System.out.println(ReadingfromMultipleFiles(e));

//        BufferedWriter("Buffer Writer", "BufferWriter.txt");
//        System.out.println(BufferedReader("BufferWriter.txt"));
//
//        System.out.println("Hi " +readline());

//        PrinterWriter("Hello Java");
//        PrinterWriter("Hello "+ readline());
    }

    static void write(int ascii) {
        try {
            FileOutputStream fout = new FileOutputStream("testout1.txt");
            fout.write(ascii);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void write(String str) {
        try {
            FileOutputStream fout = new FileOutputStream("testout.txt");
            byte b[] = str.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void write(String str, String file) {
        try {
            FileOutputStream fout = new FileOutputStream(file);

            byte b[] = str.getBytes();//converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("success...");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static char readchar(String file) {
        int i = 0;
        try {
            FileInputStream fin = new FileInputStream(file);
            i = fin.read();
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return (char) i;
    }

    static String readAll(String file) {
        String str = "";
        try {
            FileInputStream fin = new FileInputStream(file);
            int i = 0;
            while ((i = fin.read()) != -1) {
                str += (char) i;
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return str;
    }

    static void WriteBuffer(String str, String file) {
        try {
            FileOutputStream fout = new FileOutputStream(file);
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            byte b[] = str.getBytes();
            bout.write(b);
            bout.flush();
            bout.close();
            fout.close();
            System.out.println("success");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    static String ReadBuffer(String file) {
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

    static String ReadSequence(String file1, String file2) {
        String str = "";
        try {
            FileInputStream input1 = new FileInputStream(file1);
            FileInputStream input2 = new FileInputStream(file2);
            SequenceInputStream inst = new SequenceInputStream(input1, input2);
            int j = 0;
            while ((j = inst.read()) != -1) {
                str += (char) j;
            }
            inst.close();
            input1.close();
            input2.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return str;
    }

    static String ReadingfromMultipleFiles(Enumeration enumr) {
        String str = "";
        try {
            SequenceInputStream bin = new SequenceInputStream(enumr);
            int i = 0;
            while ((i = bin.read()) != -1) {
//                System.out.println(i);
                str += (char) i;
            }
            bin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return str;
    }

    static void BufferedWriter(String str, String file) {
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);
            // it also writes array of characters
            //char chars[] = {'J','a','v','a'};
            buffer.write(str);
            buffer.close();
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static String BufferedReader(String file) {
        String str = "";
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            Scanner cc = new Scanner(fr);
            cc.hasNextLine();

            int i;
            while ((i = br.read()) != -1) {
                str += (char) i;
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return str;
    }

    static void PrinterWriter(String str) {
        PrintWriter writer = new PrintWriter(System.out);
        writer.write(str);
        writer.flush();
        writer.close();
    }

    static String readline() {
        String str = "";
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            System.out.println("Enter your name");
            str = br.readLine();

        } catch (Exception e) {
            // TODO: handle exception
        }
        return str;
    }
}
