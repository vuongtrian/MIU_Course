package Assgnment_Lession_2;

public class Les_2_4 {

    public static void minAndMaxValue (int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i : arr) {
            if(i > maxValue) {
                maxValue = i;
            } else if (i < minValue) {
                minValue = i;
            }
        }
        System.out.println(maxValue + " is the maximum and the minimum is " + minValue);
    }

    public static void main(String[] args) {
        minAndMaxValue(new int[]  {1,4,-9,33,19,78,5});
    }
}
