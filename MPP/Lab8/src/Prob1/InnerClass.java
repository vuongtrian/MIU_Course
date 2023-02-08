package Prob1;

import java.util.function.Supplier;

public class InnerClass implements Supplier {
    @Override
    public Object get() {
        return Math.random();
    }
}
