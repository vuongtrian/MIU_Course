package com.FinalProject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.reflections.Reflections;
import org.springframework.stereotype.Service;

import com.custom.aop.Async;
import com.custom.aop.EventListener;
import com.custom.aop.EventService;

@Service
public class ApplicationPublishEvent implements IApplicationEventPublisher {

	private ExecutorService executor = Executors.newFixedThreadPool(100);
	
	@Override
	public void publishEvent(NewTransactionEvent event) {
		Reflections reflections = new Reflections("");
		// find and instantiate all classes annotated with the @Service annotation
		Set<Class<?>> servicetypes = reflections.getTypesAnnotatedWith(EventService.class);
		 // find all methods annotated with the @Test annotation
		
		for(Class<?> clazz: servicetypes) {
			for (Method method : clazz.getDeclaredMethods()) {
				if (method.isAnnotationPresent(EventListener.class)) {
					Object instance;
					try {
						instance = (Object)clazz.newInstance();
						if(method.isAnnotationPresent(Async.class)) {
							this.createAsyncThread(method, event, instance);
						}
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			}
		}
		
	}
	
	private void createAsyncThread(Method method, Object params, Object object) {
		System.out.println("Start- Execute method inside threadpool");
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				try {
					System.out.println("Executing method inside threadpool");
					method.invoke(object, params);
				} catch (IllegalAccessException e) {
					return;
				} catch (InvocationTargetException e) {
					return;
				}
			}
		};
		executor.execute(task);
	}

}
