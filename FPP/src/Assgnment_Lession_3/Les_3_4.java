package Assgnment_Lession_3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Les_3_4 {
    @Test
    public void recursionTest_Power_PosNumber() {
        Les_3_1 obj = new Les_3_1();
        double output = obj.power(2,3);
        double expectedRes = 8.0;
        assertEquals(expectedRes,output,1e-15);
    }

    @Test
    public void recursionTest_Power_NegNumber() {
        Les_3_1 obj = new Les_3_1();
        double output = obj.power(-2,3);
        double expectedRes = -8.0;
        assertEquals(expectedRes,output,1e-15);
    }

    @Test
    public void recursionTest_MinChar_FirstString() {
        Les_3_2 obj = new Les_3_2();
        char output = obj.minChar("fgfagd");
        char expectedRes = 'a';
        assertEquals(expectedRes,output);
    }

    @Test
    public void recursionTest_MinChar_SecondString() {
        Les_3_2 obj = new Les_3_2();
        char output = obj.minChar("dkhbcw");
        char expectedRes = 'b';
        assertEquals(expectedRes,output);
    }

    @Test
    public void binarySearchTest_ExistValue() {
        int[] arr = {4,14,24,34,44,54,64};
        Les_3_3 obj = new Les_3_3();
        int output = obj.binarySearch(arr, 0, arr.length-1, 24);
        int expectedRes = 2;
        assertEquals(expectedRes,output);
    }

    @Test
    public void binarySearchTest_NotExistValue() {
        int[] arr = {4,14,24,34,44,54,64};
        Les_3_3 obj = new Les_3_3();
        int output = obj.binarySearch(arr, 0, arr.length-1, 25);
        int expectedRes = -1;
        assertEquals(expectedRes,output);
    }

    @Test
    public void binarySearchTest_MinValue() {
        int[] arr = {4,14,24,34,44,54,64};
        Les_3_3 obj = new Les_3_3();
        int output = obj.binarySearch(arr, 0, arr.length-1, 4);
        int expectedRes = 0;
        assertEquals(expectedRes,output);
    }

    @Test
    public void binarySearchTest_MaxValue() {
        int[] arr = {4,14,24,34,44,54,64};
        Les_3_3 obj = new Les_3_3();
        int output = obj.binarySearch(arr, 0, arr.length-1, 64);
        int expectedRes = 6;
        assertEquals(expectedRes,output);
    }
}
