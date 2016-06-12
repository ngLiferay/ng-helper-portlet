package com.liferaying.service.beans;

import com.liferay.portal.kernel.util.MethodParameter;

public class MethodParameterBean {
//	private Class<?>[] _genericTypes;
	private boolean initialized;
	private String name;
	private String signatures;
	private String type;
	
	
	public MethodParameterBean(boolean initialized, String name,
			String signatures, String type) {
		this.initialized = initialized;
		this.name = name;
		this.signatures = signatures;
		this.type = type;
	}


	public MethodParameterBean(MethodParameter parameter) {
		this(false, parameter.getName(), parameter.getSignature(), parameter.getType().getName());
	}


	public boolean isInitialized() {
		return initialized;
	}


	public String getName() {
		return name;
	}


	public String getSignatures() {
		return signatures;
	}


	public String getType() {
		return type;
	}

}
