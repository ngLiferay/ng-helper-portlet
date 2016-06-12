package com.liferaying.service.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceActionMapping;
import com.liferay.portal.kernel.jsonwebservice.JSONWebServiceActionsManagerUtil;
import com.liferay.portal.kernel.util.MethodParameter;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferaying.invoke.ResourceInvoker;
import com.liferaying.service.base.NGServicesServiceBaseImpl;
import com.liferaying.service.beans.JSONWebServiceActionMappingBean;
import com.liferaying.service.beans.MethodParameterBean;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the n g services remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferaying.service.NGServicesService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferaying.service.base.NGServicesServiceBaseImpl
 * @see com.liferaying.service.NGServicesServiceUtil
 */
public class NGServicesServiceImpl extends NGServicesServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferaying.service.NGServicesServiceUtil} to access the n g services remote service.
     */
	@AccessControlled(guestAccessEnabled=true)
	public JSONObject getMethodNamesAndParams() throws Exception{
		return ResourceInvoker.getInstance().getMethodNamesAndParams();
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public JSONObject getContextServices(String contextPath, String services) throws Exception{
		
		String[] requiredServices = null;
		if(Validator.isNotNull(services)){
			requiredServices = services.split(StringPool.COMMA);
		}
		
		List<JSONWebServiceActionMapping> jsonWebServiceActionMappings = 
				JSONWebServiceActionsManagerUtil.getJSONWebServiceActionMappings(contextPath);
		
		JSONObject contextServicesJSON = JSONFactoryUtil.createJSONObject();
		
		for (JSONWebServiceActionMapping jsonWebServiceActionMapping : jsonWebServiceActionMappings) {

			Class<?> actionClass = jsonWebServiceActionMapping.getActionClass();

			String actionClassName = actionClass.getSimpleName();

			if (actionClassName.endsWith("ServiceUtil")) {
				actionClassName = actionClassName.substring(0, actionClassName.length() - 11);
			}

			//put JSONArray for each service
			String serviceName = actionClassName;

			if (serviceName.endsWith("Impl")) {
				serviceName = serviceName.substring(0, serviceName.length() - 4);
			}
			if (serviceName.endsWith("Service")) {
				serviceName = serviceName.substring(0, serviceName.length() - 7);
			}
			
			if(isServiceRequired(serviceName, requiredServices)){
				JSONArray servicesArray = contextServicesJSON.getJSONArray(serviceName);
				
				if(Validator.isNull(servicesArray)){
					servicesArray = JSONFactoryUtil.createJSONArray();
					contextServicesJSON.put(serviceName, servicesArray);
				}
				
				servicesArray.put(getActionMappingJSON(jsonWebServiceActionMapping));
			}
			
		}
		
		return contextServicesJSON;
	}

	private boolean isServiceRequired(String serviceName, String[] requiredServices) {
		
		if(requiredServices == null){
			return true;
		}
		else{
			for (String s : requiredServices) {
				if(s.equalsIgnoreCase(serviceName)){
					return true;
				}
			}
		}
		
		return false;
	}

	private String getActionMappingJSON(
			JSONWebServiceActionMapping jsonWebServiceActionMapping) {
		List<MethodParameterBean> parameterBeans = new ArrayList<MethodParameterBean>();
		for(MethodParameter parameter : jsonWebServiceActionMapping.getMethodParameters()){
			parameterBeans.add(new MethodParameterBean(parameter));
		}
		
		JSONWebServiceActionMappingBean actionMappingBean = 
				new JSONWebServiceActionMappingBean(jsonWebServiceActionMapping, parameterBeans);
		
		
		return JSONFactoryUtil.createJSONSerializer().serializeDeep(actionMappingBean);
	}
}
