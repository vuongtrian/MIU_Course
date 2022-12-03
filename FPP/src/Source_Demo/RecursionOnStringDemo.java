package Source_Demo;

public class RecursionOnStringDemo {

    // Recursive Method to find the length of a String
    public static int length(String str) {
        if(str == null || str.equals("")){
            return 0;
        } else {
            return 1 + length(str.substring(1));
        }
    }

    // Recursive method to print the string in reverse order
    public static void printCharsReverse(String str) {
        if (str == null || str.equals("")) {
            System.out.println();
        } else {
            System.out.print(str.charAt(str.length()-1));
            printCharsReverse(str.substring(0, str.length()-1));
        }
    }

    public static void printCharsReverse_2(String str) {
        if (str == null || str.equals("")) {
            return;
        } else {
            printCharsReverse_2(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    public static void main(String[] args) {
        // Find the length of String
        System.out.println("Find the length of String");
        System.out.println(length("abcd"));
        System.out.println(length(""));

        // Reverse String
        System.out.println("Reverse String");
        printCharsReverse("abcd");
        printCharsReverse("");

        // Reverse String
        System.out.println("Reverse String 2");
        printCharsReverse_2("abcd");
        printCharsReverse_2("");
    }
}
