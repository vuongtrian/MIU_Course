package Source_Demo;

public class RecursionSearchNumberInArray {

    public static void main(String[] args) {
        int[] arr = {1,5,2,7};
        System.out.println(search(arr, arr.length, 4));
        System.out.println(search(arr, arr.length, 2));
    }

    public static boolean search(int[] arr, int size, int n) {
        if (size-1 < 0) {
            return false;
        }
        if (arr[size-1] == n) {
            return true;
        }
        return search(arr,size-1,n);
    }
}
