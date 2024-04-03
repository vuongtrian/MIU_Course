package framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.reflections.Reflections;

public class FWContext {

	private ExecutorService exeService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	private Map<Class<?>, List<Object>> listeners = new HashMap<>();
    private Map<String, Object> serviceObjectMap = new HashMap<>();
    private ScheduledExecutorService appScheduler = Executors.newSingleThreadScheduledExecutor();

    public FWContext(Runnable app) {
        try {
            Reflections reflections = new Reflections("");
            Set<Class<?>> serviceTypes = reflections.getTypesAnnotatedWith(Service.class);
            for (Class<?> serviceClass : serviceTypes) {
                String className = serviceClass.getSimpleName();
                String beanName = Character.toLowerCase(className.charAt(0)) + className.substring(1);
                serviceObjectMap.put(beanName, serviceClass.getDeclaredConstructor().newInstance());
            }

            performDI(app);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void performDI(Runnable appClass) {
        try {
            Properties properties = new Properties();
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("application.properties"));

            for(Object bean : serviceObjectMap.values()) {
                Class<?> beanClass = bean.getClass();

//                field DI
                for (Field field : beanClass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Autowired.class) || field.isAnnotationPresent(Inject.class)) {
                        field.setAccessible(true);
                        Qualifier qualifier = field.getAnnotation(Qualifier.class);
                        if(qualifier != null) {
                            String qualifierValue = qualifier.value();
                            Object injectedClass = serviceObjectMap.get(qualifierValue);
                            field.set(bean, injectedClass);
                        } else {
                        	Class<?> fieldType = field.getType();
                        	Profile profile = fieldType.getAnnotation(Profile.class);
                    		if (profile == null) {
                    			Object findDIObject = getBean(fieldType.getClass());
                                field.set(bean, findDIObject);
                    		} else {
                    			for (Map.Entry<String, Object> entry : serviceObjectMap.entrySet()) {
                                    Object obj = entry.getValue();
                                    Class<?> objClass = obj.getClass();
                                    if (fieldType.isAssignableFrom(objClass)) {
                                    	Profile beanProfile = objClass.getAnnotation(Profile.class);
                                    	
                                    	String profileValue = (String) properties.get("spring.profiles.active");
                                		String profileConfig = beanProfile.value();
                                		if (profileValue.equals(profileConfig)) {
                                			Object findDIObject = getBean(objClass);
                                            field.set(bean, findDIObject);
                                		}
                                    }
                        		}
                    		}
                    		
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
                    
                    if (method.isAnnotationPresent(Scheduled.class)) {
						Scheduled scheduledAnnotation = method.getAnnotation(Scheduled.class);
//						long duration = scheduledAnnotation.fixedRate();
						String myCron = scheduledAnnotation.cron();
						String[] splitCron = myCron.split(" ");
						//always excute scheduled if the format is "seconds minutes"
						if (splitCron.length > 1) {
							long duration = (Integer.parseInt(splitCron[1].trim()) * 60 + Integer.parseInt(splitCron[0].trim())) * 1000;
							appScheduler.scheduleAtFixedRate(() -> {
		                        try {
		                            method.invoke(bean);
		                        } catch (Exception e) {
		                            e.printStackTrace();
		                        }
							}, 10, duration, TimeUnit.MILLISECONDS);
						}
					}
                    
                    if (method.isAnnotationPresent(EventListener.class)) {
						Class<?> eventType = method.getParameterTypes()[0];
						List<Object> list = listeners.get(eventType);
						if (list == null) {
							list = new ArrayList<>();
						}
						list.add(bean);
						listeners.put(eventType, list);
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

//            scan for AppClass
            for (Field field: appClass.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class) || field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);

                    Qualifier qualifier = field.getAnnotation(Qualifier.class);
                    if(qualifier != null) {
                        String qualifierValue = qualifier.value();
                        Object findDIObject = serviceObjectMap.get(qualifierValue);
                        field.set(appClass, findDIObject);
                    } else {
                        Object findDIObject = serviceObjectMap.get(field.getName());
                        field.set(appClass, findDIObject);
                    }
                } else if (field.isAnnotationPresent(Value.class)) {
                    field.setAccessible(true);
                    Value valAnnotation = field.getAnnotation(Value.class);
                    String valKey = valAnnotation.value().trim();
                    String value = properties.getProperty(valKey);
                    Object convertedValue = convertValue(value, field.getType());
                    field.set(appClass, convertedValue);
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
    
    public void puhlishEvent(Object message) {
		Class<?> type = message.getClass();
		List<Object> list = listeners.get(type);
		
		if (list != null && list.size() > 0) {
			try {
				for (Object item : list) {
					Class<?> myClass = item.getClass();
					for (Method method: myClass.getDeclaredMethods()) {
						if (method.isAnnotationPresent(EventListener.class)) {
							if (method.isAnnotationPresent(Async.class)) {
								CompletableFuture.runAsync(() -> {
						            try {
						            	
						            	System.out.println(method.getName() + " starts");
						            	method.invoke(item, message);
						                System.out.println(method.getName() + " ends");
						                
						            } catch (Exception ex) {
						                ex.printStackTrace();
						            }
						        }, exeService);
							} else {
								method.invoke(item, message);
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
