package com.FinalProject.Application;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.FinalProject.Category;
import com.FinalProject.ITransactionService;
import com.custom.aop.FWContext;


@Configuration
@ComponentScan("com.FinalProject")
public class FWApplication {
	public static void main(String[] args) {
	}
    public static void run(Class<?> clazz, String[] args) {
    	Object instance;
		try {
			instance = clazz.newInstance();
			new FWContext(instance);
			for (Method method : instance.getClass().getDeclaredMethods()) {
	    		if("run".equals(method.getName()))
					method.invoke(instance);
	    	}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}  catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

