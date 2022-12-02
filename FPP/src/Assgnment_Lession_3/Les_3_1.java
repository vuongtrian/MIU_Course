package Assgnment_Lession_3;

public class Les_3_1 {

    public double power (double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * power(x, n-1);
    }

    public void main(String[] args) {
        System.out.println(power(2,2));
    }
}
