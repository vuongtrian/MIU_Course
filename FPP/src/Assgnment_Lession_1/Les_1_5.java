package Assgnment_Lession_1;

public class Les_1_5 {
    public static int maxValue (int x, int y, int z) {
        int[] arr = {x,y,z};
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxValue(24,62,38));
    }
}
