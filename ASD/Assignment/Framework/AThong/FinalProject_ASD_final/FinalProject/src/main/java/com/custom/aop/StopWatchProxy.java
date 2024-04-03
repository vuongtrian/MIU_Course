package com.custom.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class StopWatchProxy implements InvocationHandler {
	private Object target;

	public StopWatchProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		Reflections reflections = new Reflections("");
		Set<Class<?>> aspecttypes = reflections.getTypesAnnotatedWith(CustomAspect.class);
		Object returnValue = null;
		for(Class<?> clazz: aspecttypes) {
			Object instance= clazz.newInstance();
			for (Method aspectMethod : clazz.getDeclaredMethods()) {
				
				if (aspectMethod.isAnnotationPresent(Before.class) &&
						this.checkPointCut(method, aspectMethod.getAnnotation(Before.class).pointcut())) {
					Object[] params= aspectMethod.getParameters();
					aspectMethod.invoke(instance, params);
					
				}
			}
			// find the @Around method
			boolean isAround = false;
			for (Method methodAspect : clazz.getDeclaredMethods()) {
				if (methodAspect.isAnnotationPresent(Around.class) &&
						this.checkPointCut(method, methodAspect.getAnnotation(Around.class).pointcut())) {
					methodAspect.invoke(instance, method, target, args);
					isAround = true;
				}
			}
			// invoke service method
			if (!isAround) {
				// invoke the method on the target
				returnValue = method.invoke(target, args);
			}

			// find the @After method
			for (Method methodAspect : clazz.getDeclaredMethods()) {
				if (methodAspect.isAnnotationPresent(After.class) &&
						this.checkPointCut(method, methodAspect.getAnnotation(After.class).pointcut())) {
					methodAspect.invoke(instance);
				}
			}
		}
		return null;
	}
	
	private boolean checkPointCut(Method method, String pointcut) {
		String[] pointCuts = pointcut.split("\\.");
			return pointCuts.length == 2 && method.getDeclaringClass().getSimpleName().equalsIgnoreCase(pointCuts[0]) &&
					method.getName().equalsIgnoreCase(pointCuts[1]);
		
	}
}

