package with.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CachingProxy implements InvocationHandler {
	private Object target;
	Map<String, Object> cache = new HashMap<String, Object>();

	public CachingProxy(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String key = ""+args[0];
		Object cachedObject = cache.get(key);
		if (cachedObject == null) {
			Object result = method.invoke(target, args);
			cache.put(key, result);
			return result;
		} else
			return cachedObject;
	}
}
