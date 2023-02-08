package Prob1;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        Supplier<Double> random = () -> Math.random();
//        System.out.println(random.get());
        InnerClass inner = new InnerClass();
        System.out.println(inner.get());
    }


}
