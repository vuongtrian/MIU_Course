package Source_Demo;

public class RecursionReverseNumber {
    public static void main(String[] args) {
        reverse(3124);
        System.out.println();
        reverse_2(3124);
    }

    public static void reverse(int n) {
        if (n > 0){
            System.out.print(n % 10);
            reverse(n/10);
        }
    }

    public static void reverse_2(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        } else {
            System.out.print(n % 10);
            reverse(n/10);
        }
    }
}
