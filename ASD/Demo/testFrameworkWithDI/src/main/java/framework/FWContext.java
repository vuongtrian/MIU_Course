package framework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class FWContext {

	private static List<Object> testObjectMap = new ArrayList<>();
	private static List<Object> serviceObjectMap = new ArrayList<>();

	public FWContext() {
		try {			
			Reflections reflections = new Reflections("");
			// find and instantiate all classes annotated with the @TestClass annotation
			Set<Class<?>> testtypes = reflections.getTypesAnnotatedWith(TestClass.class);
			for (Class<?> testClass : testtypes) {
				testObjectMap.add((Object) testClass.newInstance());
			}
			// find and instantiate all classes annotated with the @Service annotation
			Set<Class<?>> servicetypes = reflections.getTypesAnnotatedWith(Service.class);
			for (Class<?> serviceClass : servicetypes) {
				serviceObjectMap.add((Object) serviceClass.newInstance());
			}

			performDI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void performDI() {
		try {
			for (Object theTestClass : testObjectMap) {
		         // find annotated fields
				 for (Field field : theTestClass.getClass().getDeclaredFields()) {
			            if (field.isAnnotationPresent(Inject.class)) {
			                // get the type of the field
			            	Class<?> theFieldType =field.getType();
			            	//get the object instance of this type
			            	Object instance = getServiceBeanOftype(theFieldType);
			            	//do the injection
			            	field.setAccessible(true);
			            	field.set(theTestClass, instance);
			            }
			        }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	public Object getServiceBeanOftype(Class interfaceClass) {
		Object service = null;
		try {
			for (Object theClass : serviceObjectMap) {
				Class<?>[] interfaces = theClass.getClass().getInterfaces();
				
				for (Class<?> theInterface : interfaces) {
					if (theInterface.getName().contentEquals(interfaceClass.getName()))
						service = theClass;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	public void start() {
		try {
			for (Object theTestClass : testObjectMap) {
				Method beforeMethod = null;
				//find the @before method
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					if (method.isAnnotationPresent(Before.class)) {
						beforeMethod = method;
					}
				}
				// find all methods annotated with the @Test annotation
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					if (method.isAnnotationPresent(Test.class)) {
						//first call the before method
						if (beforeMethod!= null) beforeMethod.invoke(theTestClass);
						method.invoke(theTestClass);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
