package framework;

import org.reflections.Reflections;

import java.io.FileInputStream;
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
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/application.properties"));

            for(Object bean : serviceObjectMap.values()) {
                Class<?> beanClass = bean.getClass();

//                field DI
                for (Field field : beanClass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Autowired.class)) {
                        field.setAccessible(true);
                        Qualifier qualifier = field.getAnnotation(Qualifier.class);

                        if(qualifier != null) {
                            String qualifierValue = qualifier.value();
                            Object injectedClass = serviceObjectMap.get(qualifierValue);
                            field.set(bean, injectedClass);
                        }

                    } else if(field.isAnnotationPresent(Value.class)) {
                        field.setAccessible(true);
                        Value getValue = field.getAnnotation(Value.class);
                        String valueKey = getValue.value().trim();
                        String value = properties.getProperty(valueKey);
                        Object convertedValue = convertValue(value, field.getType());
                        field.set(bean, convertedValue);
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

    private Object convertValue(String value, Class<?> targetType) {
        if (targetType == int.class || targetType == Integer.class) {
            return Integer.parseInt(value);
        } else if (targetType == long.class || targetType == Long.class) {
            return Long.parseLong(value);
        } else if (targetType == float.class || targetType == Float.class) {
            return Float.parseFloat(value);
        } else if (targetType == double.class || targetType == Double.class) {
            return Double.parseDouble(value);
        } else if (targetType == boolean.class || targetType == Boolean.class) {
            return Boolean.parseBoolean(value);
        } else {
            return value;
        }
    }
}
