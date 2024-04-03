package framework;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class FWContext {

    private Map<Class<?>, Object> serviceObjectMap = new HashMap<>();

    public FWContext() {
        try {
            Reflections reflections = new Reflections("");
            Set<Class<?>> serviceTypes = reflections.getTypesAnnotatedWith(Service.class);
            for (Class<?> serviceClass : serviceTypes) {
                serviceObjectMap.put(serviceClass, serviceClass.newInstance());
            }

            performDI();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void performDI() {
        try {
            for(Object bean : serviceObjectMap.values()) {
                for (Field field : bean.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(Autowired.class)) {
                        field.setAccessible(true);
                        field.set(bean, serviceObjectMap.get(field.getType()));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean (Class<?> myClass) {
        return serviceObjectMap.get(myClass);
    }
}
