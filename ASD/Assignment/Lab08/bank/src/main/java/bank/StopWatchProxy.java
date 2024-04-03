package bank;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StopWatchProxy implements InvocationHandler {
    private Object target;

    public StopWatchProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        // invoke the method on the target
        Object returnValue = method.invoke(target, args);

        stopwatch.stop();
        System.out.println("The method " + method.getName() + " took " + stopwatch.getMillis() + " ms");
        return returnValue;
    }
}
