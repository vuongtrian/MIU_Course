package framework;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class FWContext {

    private Map<String, Object> serviceObjectMap = new HashMap<>();

    public FWContext() {
        try {
            Reflections reflections = new Reflections("");
            Set<Class<?>> serviceTypes = reflections.getTypesAnnotatedWith(Service.class);
            for (Class<?> serviceClass : serviceTypes) {
                String className = serviceClass.getSimpleName();
                String beanName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
                serviceObjectMap.put(beanName, serviceClass.getDeclaredConstructor().newInstance());
            }

            performDI();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void performDI() {
        try {
            for(Object bean : serviceObjectMap.values()) {
                Class<?> beanClass = bean.getClass();

//                field DI
                for (Field field : beanClass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Autowired.class)) {
                        field.setAccessible(true);
                        Qualifier qualifier = field.getAnnotation(Qualifier.class);
//                        Object injectedClass = null;
                        if(qualifier != null) {
                            String qualifierValue = qualifier.value();
                            Object injectedClass = serviceObjectMap.get(qualifierValue);
                            field.set(bean, injectedClass);
                        }

                    }
                }

//                method DI
                for (Method method : beanClass.getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Autowired.class)) {
                        Class<?>[] paramTypes = method.getParameterTypes();
                        if (paramTypes.length > 0) {
                            String className = paramTypes[0].getSimpleName();
                            String beanName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
                            Object injectedClass = serviceObjectMap.get(beanName);
                            method.invoke(bean, injectedClass);
                        }
                    }
                }

//                constructor DI
                Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
                for(Constructor<?> constructor : constructors) {
                    if(constructor.isAnnotationPresent(Autowired.class)) {
                        Class<?>[] paramTypes = constructor.getParameterTypes();
                        int length = paramTypes.length;
                        Object[] arguments = new Object[length];
                        for (int i = 0; i < length; i++) {
                            String className = paramTypes[0].getSimpleName();
                            String beanName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
                            Object injectedClass = serviceObjectMap.get(beanName);
                            arguments[i] = injectedClass;
                        }
                        constructor.setAccessible(true);
                        String className = beanClass.getSimpleName();
                        String beanName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
                        serviceObjectMap.put(beanName, constructor.newInstance(arguments));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean (Class<?> myClass) {
        String className = myClass.getSimpleName();
        String beanName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
        return serviceObjectMap.get(beanName);
    }


}
