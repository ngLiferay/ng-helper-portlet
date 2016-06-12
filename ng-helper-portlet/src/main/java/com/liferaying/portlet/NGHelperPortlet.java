package com.liferaying.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferaying.invoke.ResourceInvoker;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class NGHelperPortlet extends MVCPortlet {
	
	ResourceInvoker invoker;
	
	@Override
	public void init() throws PortletException {
		super.init();
		
		try {
			invoker = ResourceInvoker.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		super.destroy();
		invoker.destroy();
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException, IOException {
		
		//resourceID is the method name & used by resource invoker
		String resourceID = resourceRequest.getResourceID();
		
		Object response;
		try {
			resourceResponse.setContentType(ContentTypes.TEXT_JAVASCRIPT);
			response = invoker.invoke(resourceID, resourceRequest);
			
		} catch(InvocationTargetException e){
			response = getExceptionJSON(e.getTargetException());
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500"); 
			
		}catch (Exception e) {
			response = getExceptionJSON(e);
			resourceResponse.setProperty(ResourceResponse.HTTP_STATUS_CODE, "500"); 
		}
		
		PortletResponseUtil.write(resourceResponse, response.toString());
		
	}

	private Object getExceptionJSON(Throwable throwable) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		jsonObject.put("message", throwable.getMessage());
		jsonObject.put("type", throwable.getClass().getName());
		
		return jsonObject;
	}

}
