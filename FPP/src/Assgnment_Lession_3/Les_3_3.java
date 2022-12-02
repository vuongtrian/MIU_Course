package Assgnment_Lession_3;

import java.util.Arrays;
import java.util.Scanner;

public class Les_3_3 {

    public int binarySearch (int[] arr, int left, int right, int target) {
        if (right >= left) {
            int midIndex = (left + right) / 2;
            if (target == arr[midIndex]) {
                return midIndex;
            }
            if (target > arr[midIndex]) {
                return binarySearch(arr, midIndex+1, right, target);
            }  else {
                return binarySearch(arr, left, midIndex-1, target);
            }
        }
        return -1;
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter array size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Enter value " + (i+1) + " : ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Current array: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        System.out.println("Please input target: ");
        int target = sc.nextInt();

        System.out.println("Result: " + this.binarySearch(arr, 0, arr.length-1, target));
    }
}
