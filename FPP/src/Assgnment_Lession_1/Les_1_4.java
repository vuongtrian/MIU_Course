package Assgnment_Lession_1;

public class Les_1_4 {

    public static boolean checkContain (String[] arrStr, String value) {
        for(String i : arrStr) {
            if (i.equals(value)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] arr = {"Andy", "Sophia", "Alex"};

        System.out.println(checkContain(arr, "Alex"));
        System.out.println(checkContain(arr, "Victor"));
    }
}
