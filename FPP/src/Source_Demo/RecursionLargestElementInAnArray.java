package Source_Demo;

public class RecursionLargestElementInAnArray {

    public static int largest(int[] list,int lowerIndex, int upperIndex) {
        int max;

        if (lowerIndex == upperIndex) {
            return list[lowerIndex];
        } else {
            max = largest(list, lowerIndex+1, upperIndex);
            if (list[lowerIndex] >= max) {
                return list[lowerIndex];
            } else {
                return max;
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {5,7,2,8,4,6};
        System.out.println();
    }
}
