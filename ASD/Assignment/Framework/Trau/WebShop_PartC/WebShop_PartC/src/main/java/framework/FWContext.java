package framework;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.reflections.Reflections;

public class FWContext {

	private Map<String, Object> serviceObjectMap = new HashMap<>();

	public FWContext() {
		try {

			Reflections reflections = new Reflections("");
			Set<Class<?>> serviceTypes = reflections.getTypesAnnotatedWith(Service.class);
			for (Class<?> serviceClass: serviceTypes) {
				serviceObjectMap.put(getBeanName(serviceClass), serviceClass.getDeclaredConstructor().newInstance());
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

			for (Object bean : serviceObjectMap.values()) {
				Class<?> beanClass = bean.getClass();

				//@Autowired for fields
				for (Field field: beanClass.getDeclaredFields()) {
					if (field.isAnnotationPresent(Autowired.class)) {
						field.setAccessible(true);
						field.set(bean, findDIWithField(field));
					} else if (field.isAnnotationPresent(Value.class)) {
						field.setAccessible(true);
						String value = valueFromProperties(properties, field);
						Object convertedValue = convertValue(value, field.getType());
						field.set(bean, convertedValue);
					}
				}

				//@Autowired for methods
				for (Method method: beanClass.getDeclaredMethods()) {
					if (method.isAnnotationPresent(Autowired.class)) {
						Class<?>[] parameterTypes = method.getParameterTypes();
						if (parameterTypes.length > 0) {
							method.invoke(bean, findDIWithClass(parameterTypes[0]));
						}
					}
				}

				//@Autowired for constructors
				for (Constructor<?> constructor: beanClass.getDeclaredConstructors()) {
					if (constructor.isAnnotationPresent(Autowired.class)) {
						Class<?>[] parameterTypes = constructor.getParameterTypes();
						int length = parameterTypes.length;
						Object[] arguments = new Object[length];
						for (int i = 0; i < length; i++) {
							arguments[i] = findDIWithClass(parameterTypes[i]);
						}
						constructor.setAccessible(true);
						serviceObjectMap.put(getBeanName(beanClass), constructor.newInstance(arguments));
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private Object findDIWithField(Field field) {
		Qualifier qualifier = field.getAnnotation(Qualifier.class);
		if (qualifier != null) {
			String qualifierValue = qualifier.value();
			return serviceObjectMap.get(qualifierValue);
		}

		return findDIWithClass(field.getType());
	}

	private Object findDIWithClass(Class<?> type) {
		return serviceObjectMap.get(getBeanName(type));
	}

	public Object getBean(Class<?> myClass) {
		return getBeanByName(getBeanName(myClass));
	}

	public Object getBeanByName(String name) {
		return serviceObjectMap.get(name);
	}

	private String getBeanName(Class<?> myClass) {
		String className = myClass.getSimpleName();
		return Character.toLowerCase(className.charAt(0)) + className.substring(1);
	}

	private String valueFromProperties(Properties properties, Field field) {
		Value valAnnotation = field.getAnnotation(Value.class);
		String valKey = valAnnotation.value().trim();
		return properties.getProperty(valKey);
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
