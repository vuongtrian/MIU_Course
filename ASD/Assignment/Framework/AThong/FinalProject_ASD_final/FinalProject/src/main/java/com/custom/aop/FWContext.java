package com.custom.aop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class FWContext {

	private static List<Object> customServiceObjectMap = new ArrayList<>();
	private static List<Object> aspectObjectMap = new ArrayList<>();

	private static List<Object> serviceObjectMap = new ArrayList<>();
	private static List<Object> repositoryObjectMap = new ArrayList<>();
	private static String profile=null;
	
	public FWContext(Object application) {
		try {
			Reflections reflections = new Reflections("");
			profile= this.getValueFromApplicationProperties("spring.profiles.active");

			// find and instantiate all classes annotated with the @Service annotation
			Set<Class<?>> customServicetypes = reflections.getTypesAnnotatedWith(CustomService.class);
			for (Class<?> serviceClass : customServicetypes) {
				Object instance = (Object) serviceClass.newInstance();
				
				Class<?>[] interfaces= serviceClass.getInterfaces();
				for(Class<?> in: interfaces) {
					Object instanceProxy= Proxy.newProxyInstance(in.getClassLoader(), 
                            new Class[] { in },
                            new StopWatchProxy(instance));
					customServiceObjectMap.add(instanceProxy);
				}
			}

			// find and instantiate all classes annotated with the @Service annotation
			Set<Class<?>> repositorytypes = reflections.getTypesAnnotatedWith(Repository.class);
			for (Class<?> serviceClass : repositorytypes) {
				repositoryObjectMap.add((Object) serviceClass.newInstance());
			}
			
			// find and instantiate all classes annotated with the @Service annotation
			Set<Class<?>> servicetypes = reflections.getTypesAnnotatedWith(Service.class);
			for (Class<?> serviceClass : servicetypes) {
				// find all methods annotated with the @Test annotation
				if (serviceClass.getConstructors().length > 0) {
					for (Constructor<?> constructor : serviceClass.getConstructors()) {
						if (constructor.isAnnotationPresent(Autowired.class)) {
							for (Class<?> clazzType : constructor.getParameterTypes()) {
								Object instance = getServiceBeanOftype(clazzType, null);
								Object instanceService = (Object) constructor.newInstance(instance);
								this.injectFieldType(serviceClass, instanceService);
								serviceObjectMap.add(instanceService);
							}
						} else {
							serviceObjectMap.add((Object) serviceClass.newInstance());
						}
					}
				}

			}

			// find and instantiate all classes annotated with the @Service annotation
			Set<Class<?>> aspecttypes = reflections.getTypesAnnotatedWith(CustomAspect.class);
			for (Class<?> aspectClass : aspecttypes) {
				aspectObjectMap.add((Object) aspectClass.newInstance());
			}
			
			for (Field field : application.getClass().getDeclaredFields()) {
				if (field.isAnnotationPresent(Autowired.class)) {
					// get the type of the field
					Class<?> theFieldType = field.getType();
					// get the object instance of this type
					Object instance = getServiceBeanOftype(theFieldType, null);
					if(field.isAnnotationPresent(Qualifier.class)) {
						instance = getServiceBeanOftype(theFieldType, field.getAnnotation(Qualifier.class).value());
					}
					// do the injection
					field.setAccessible(true);
					field.set(application, instance);
				}
				if (field.isAnnotationPresent(Value.class)) {
					String key = field.getAnnotation(Value.class).value();
					String value= this.getValueFromApplicationProperties(key);
					field.setAccessible(true);
					field.set(application, value);
				}
			}

			performDI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void performDI() {
		try {

			for (Object theTestClass : serviceObjectMap) {
				// find annotated fields
				for (Field field : theTestClass.getClass().getDeclaredFields()) {
					if (field.isAnnotationPresent(Autowired.class)) {
						// get the type of the field
						Class<?> theFieldType = field.getType();
						// get the object instance of this type
						Object instance = getServiceBeanOftype(theFieldType, null);
						if(field.isAnnotationPresent(Qualifier.class)) {
							instance = getServiceBeanOftype(theFieldType, field.getAnnotation(Qualifier.class).value());
						}
						// do the injection
						field.setAccessible(true);
						field.set(theTestClass, instance);
					}
					if (field.isAnnotationPresent(Value.class)) {
						String key = field.getAnnotation(Value.class).value();
						String value= this.getValueFromApplicationProperties(key);
						field.setAccessible(true);
						field.set(theTestClass, value);
					}
				}
				// find all methods annotated with the @Autowired annotation
				for (Method method : theTestClass.getClass().getDeclaredMethods()) {
					if (method.isAnnotationPresent(Autowired.class)) {
						List<Object> objectParams = this.getParamsAnnotation(method);
						method.invoke(theTestClass, objectParams.toArray());
					}
					if (method.isAnnotationPresent(Scheduled.class)) {
						this.createScheduling(method, theTestClass);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getServiceBeanOftype(Class interfaceClass, String qualifier) {
		Object service = null;
		try {
			for (Object theClass : serviceObjectMap) {
				Class<?>[] interfaces = theClass.getClass().getInterfaces();
				for (Class<?> theInterface : interfaces) {
					if (theInterface.getName().contentEquals(interfaceClass.getName())) {
						if(theClass.getClass().isAnnotationPresent(Profile.class) &&
								this.checkProfileAnnotation(theClass)) {
							return theClass;
						} else {
							if(qualifier != null && theClass.getClass().getSimpleName().equalsIgnoreCase(qualifier)) {
								return theClass;
							} else {
								service = theClass;
							}
							
						}
						
					}
				}
			}
			for (Object theClass : repositoryObjectMap) {
				Class<?>[] interfaces = theClass.getClass().getInterfaces();
				for (Class<?> theInterface : interfaces) {
					if (theInterface.getName().contentEquals(interfaceClass.getName())) {
						if(theClass.getClass().isAnnotationPresent(Profile.class) &&
								this.checkProfileAnnotation(theClass)) {
							return theClass;
						} else {
							if(qualifier != null && theClass.getClass().getSimpleName().equalsIgnoreCase(qualifier)) {
								return theClass;
							} else {
								service = theClass;
							}
							
						}
						
					}
						
				}
			}
			for (Object theClass : customServiceObjectMap) {
				Class<?>[] interfaces = theClass.getClass().getInterfaces();
				for (Class<?> theInterface : interfaces) {
					if (theInterface.getName().contentEquals(interfaceClass.getName())) {
						if(theClass.getClass().isAnnotationPresent(Profile.class) &&
								this.checkProfileAnnotation(theClass)) {
							return theClass;
						} else {
							if(qualifier != null && theClass.getClass().getSimpleName().equalsIgnoreCase(qualifier)) {
								return theClass;
							} else {
								service = theClass;
							}
							
						}
						
					}
						
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return service;
	}

	public void startAspect() {
		try {
			for (Object serviceClass : customServiceObjectMap) {
				for (Method method : serviceClass.getClass().getDeclaredMethods()) {
					Object theTestClass = findAspectClass(method);
					// find the @Before method
					if (theTestClass == null)
						break;
					for (Method methodAspect : theTestClass.getClass().getDeclaredMethods()) {
						if (methodAspect.isAnnotationPresent(Before.class)) {
							List<Object> params= getParamsAnnotation(methodAspect);
							methodAspect.invoke(theTestClass, params.toArray());
						}
					}
					// find the @Around method
					boolean isAround = false;
					for (Method methodAspect : theTestClass.getClass().getDeclaredMethods()) {
						if (methodAspect.isAnnotationPresent(Around.class)) {
							List<Object> params= getParamsAnnotation(methodAspect);
							methodAspect.invoke(theTestClass, method, serviceClass, params.toArray());
							isAround = true;
						}
					}
					// invoke service method
					if (!isAround) {
						method.invoke(serviceClass, "Test");
					}

					// find the @After method
					for (Method methodAspect : theTestClass.getClass().getDeclaredMethods()) {
						if (methodAspect.isAnnotationPresent(After.class)) {
							List<Object> params= getParamsAnnotation(methodAspect);
							methodAspect.invoke(theTestClass, params.toArray());
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object findAspectClass(Method serviceMethod) {
		for (Object theTestClass : aspectObjectMap) {
			for (Method methodAspect : theTestClass.getClass().getDeclaredMethods()) {
				if (methodAspect.getAnnotations()[0].toString().indexOf(serviceMethod.getName()) >= 0) {
					return theTestClass;
				}
			}
		}
		return null;
	}

	private void injectFieldType(Class<?> clazz, Object instanceService)
			throws IllegalArgumentException, IllegalAccessException {
		// find annotated fields
		for (Field field : clazz.getDeclaredFields()) {
			// get the type of the field
			Class<?> theFieldType = field.getType();
			// get the object instance of this type
			Object instance = getServiceBeanOftype(theFieldType, null);
			// do the injection
			field.setAccessible(true);
			field.set(instanceService, instance);
		}
	}

	private String getValueFromApplicationProperties(String name) {
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			Properties prop = new Properties();
			// load the properties file
			prop.load(new FileInputStream(rootPath + "/application.properties"));
			// get the property value
			return prop.getProperty(name);
			
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}
	
	private boolean checkProfileAnnotation(Object clazz) {
		for(Annotation annotation: clazz.getClass().getAnnotations()) {
			if(annotation.annotationType().getSimpleName().equals(Profile.class.getSimpleName()) &&
			   annotation.toString().indexOf(profile) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	private void createScheduling(Method method, Object object) {
		
		ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				try {
					method.invoke(object);
				} catch (IllegalAccessException e) {
					return;
				} catch (InvocationTargetException e) {
					return;
				}
			}
		};   
		int fixedRate = method.getAnnotation(Scheduled.class).fixedRate();
		String cron = method.getAnnotation(Scheduled.class).cron();
		
		
		if(!"".equals(cron)) {
			String[] value = cron.split(" ");
			int timeRate = Integer.parseInt(value[0]) + Integer.parseInt(value[1]) * 60;
			executor.scheduleWithFixedDelay(task, 0, timeRate, TimeUnit.SECONDS);
		} else {
			executor.scheduleWithFixedDelay(task, 0, fixedRate, TimeUnit.MILLISECONDS);
		}
	}
	
	private List<Object> getParamsAnnotation(Method method) {
		List<Object> objectParams = new ArrayList<Object>();
		for (Class<?> clazzType : method.getParameterTypes()) {
			Object instance = getServiceBeanOftype(clazzType, null);
			objectParams.add(instance);
		}
		return objectParams;
	}
}
