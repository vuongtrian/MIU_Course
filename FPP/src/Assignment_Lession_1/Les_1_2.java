package Assignment_Lession_1;

public class Les_1_2 {

    public static int[] count (int[] arr) {
        int countOdd = 0;
        int countEven = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }

        int[] res = new int[2];
        res[0] = countOdd;
        res[1] = countEven;

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] res = count(arr);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
