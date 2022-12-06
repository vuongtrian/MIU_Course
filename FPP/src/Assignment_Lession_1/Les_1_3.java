package Assignment_Lession_1;

public class Les_1_3 {
    public static void count (int[] arr) {
        int countOdd = 0;
        int countEven = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }

        System.out.println("Count of even number: " + countEven);
        System.out.println("Count of odd number: " + countOdd);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        count(arr);
    }
}
