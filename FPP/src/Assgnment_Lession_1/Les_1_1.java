package Assgnment_Lession_1;

public class Les_1_1 {

    public static float averageArray (int[] arr) {
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(averageArray(arr));
    }
}
