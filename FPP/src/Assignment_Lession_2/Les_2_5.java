package Assignment_Lession_2;

public class Les_2_5 {

    public static boolean isEqual (int[] arr1, int[] arr2) {
        boolean flag = true;
        if (arr1.length != arr2.length) {
            flag = false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,6,6,7};
        int[] arr2 = {1,3,5,6,6,7};
        System.out.println(isEqual(arr1,arr2));

        int[] arr3 = {1,3,5};
        int[] arr4 = {1,3,5,7};
        System.out.println(isEqual(arr3,arr4));
    }
}
