package com.liferaying.invoke;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferaying.portlet.NGHelperPortlet;
import com.liferaying.util.NGHelperConstants;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ResourceRequest;

/**
 * Class used to read util class methods & invoke from {@link NGHelperPortlet} serveResource by resourceID.
 * @author Yogesh Agarwal
 */
public class ResourceInvoker {

	private Map<String, MethodKey> cache = new HashMap<String, MethodKey>();
	private String[] utilClasses = NGHelperConstants.ResourceUtilClasses.NAMES;
	private static JSONObject methodNamesAndParams = JSONFactoryUtil.createJSONObject();
	private static ResourceInvoker instance;

	/**
	 * 
	 * @return {@link ResourceInvoker}
	 * @throws Exception
	 */
	public static ResourceInvoker getInstance() throws Exception {

		if (instance == null) {
			instance = new ResourceInvoker();
		}

		return instance;
	}

	private ResourceInvoker() throws Exception {
		init();
	}

	/**
	 * Method will fetch methods from util classes & process it for invoking
	 * @throws Exception
	 */
	private void init() throws Exception {
		for (String c : utilClasses) {
			Class<?> clazz = Class.forName(c);
			System.out.println(clazz);
			System.out.println(clazz.getMethods());
			for (Method method : clazz.getMethods()) {
				if(method.getReturnType() == JSONObject.class || 
						method.getReturnType() == JSONArray.class){
					System.out.println(method);
					putInCache(new MethodKey(method));
					updateMethodMeta(method);
				}
			}
		}

	}

	/**
	 * Fetch util method metadata from {@link MethodParams} annotation.
	 * @param method
	 */
	private void updateMethodMeta(Method method) {
		JSONArray array = JSONFactoryUtil.createJSONArray();
		MethodParams params = method.getAnnotation(MethodParams.class);
		if(params != null){
			for(String s: params.names()){
				array.put(s);
			}
		}
		
		methodNamesAndParams.put(method.getName(), array);
	}

	/**
	 * Caching {@link MethodKey} 
	 * @param methodKey
	 * @throws Exception
	 */
	private void putInCache(MethodKey methodKey) throws Exception {
		String name = methodKey.getMethodName();
		if (cache.get(name) != null) {
			throw new Exception("Method already exists: "
					+ cache.get(name).toString());
		}
		cache.put(name, methodKey);
	}
	
	/**
	 * Invokes the util method, by passing {@link ResourceRequest}.<br> 
	 * Every util method must be have only one parameter of {@link ResourceInvoker} and 
	 * returns {@link Object}
	 * @param methodName Method Name
	 * @param request Resource Request
	 * @return {@link JSONObject} Result of util method
	 * @throws Exception
	 */
	public Object invoke(String methodName, ResourceRequest request) throws Exception {
		MethodHandler handler = new MethodHandler(cache.get(methodName), request);
		return handler.invoke(false);
	}

	/**
	 * @return {@link JSONObject} JSON of method names & params array
	 */
	public JSONObject getMethodNamesAndParams() {
		return methodNamesAndParams;
	}
	
	public void destroy() {
		cache.clear();
		cache = null;		
		methodNamesAndParams = null;
	}

}
