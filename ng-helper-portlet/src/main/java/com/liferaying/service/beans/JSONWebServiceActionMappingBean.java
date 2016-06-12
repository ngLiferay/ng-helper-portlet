package com.liferaying.service.beans;

import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceActionMapping;

import java.util.List;

public class JSONWebServiceActionMappingBean {

	private String actionClass;
	private String actionMethod;
	private String contextPath;
	private String fullPath;
	private String method;
	private List<MethodParameterBean> methodParameters;
	private String path;
	private String signature;
	
	
	public JSONWebServiceActionMappingBean(String actionClass,
			String actionMethod, String contextPath, 
			String method, List<MethodParameterBean> methodParameters, String path,
			String signature) {
		this.actionClass = actionClass;
		this.actionMethod = actionMethod;
		this.contextPath = contextPath;
		this.method = method;
		this.methodParameters = methodParameters;
		this.path = path;
		this.signature = signature;
		this.fullPath = contextPath + path;
	}


	public JSONWebServiceActionMappingBean(
			JSONWebServiceActionMapping jsonWebServiceActionMapping,
			List<MethodParameterBean> parameterBeans) {
		
		this(jsonWebServiceActionMapping.getActionClass().getName(), 
				jsonWebServiceActionMapping.getActionMethod().getName(), jsonWebServiceActionMapping.getContextPath(),
				jsonWebServiceActionMapping.getMethod(),parameterBeans, jsonWebServiceActionMapping.getPath(),
				jsonWebServiceActionMapping.getSignature());
	}


	public String getActionClass() {
		return actionClass;
	}


	public String getActionMethod() {
		return actionMethod;
	}


	public String getContextPath() {
		return contextPath;
	}


	public String getFullPath() {
		return fullPath;
	}


	public String getMethod() {
		return method;
	}


	public List<MethodParameterBean> getMethodParameters() {
		return methodParameters;
	}


	public String getPath() {
		return path;
	}


	public String getSignature() {
		return signature;
	}
	
	
}
