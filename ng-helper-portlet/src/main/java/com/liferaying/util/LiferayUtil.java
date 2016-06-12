package com.liferaying.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.security.auth.AuthTokenUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import javax.portlet.ResourceRequest;

public class LiferayUtil {
	
	public static JSONObject getThemeDisplayJSON(ResourceRequest request) throws JSONException{
		ThemeDisplay themeDisplay = NGHelperUtil.getThemeDisplay(request);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put(NGHelperConstants.TD.IS_SIGNED_IN, themeDisplay.isSignedIn());
		jsonObject.put(NGHelperConstants.TD.SCOPE_GROUP_ID, themeDisplay.getScopeGroupId());
		jsonObject.put(NGHelperConstants.TD.COMPANY_ID, themeDisplay.getCompanyId());
		jsonObject.put(NGHelperConstants.TD.COMPANY_GROUP_ID, themeDisplay.getCompanyGroupId());
		jsonObject.put(NGHelperConstants.TD.LANGUAGE_ID, themeDisplay.getLanguageId());
		jsonObject.put(NGHelperConstants.TD.USER, NGHelperUtil.serializeLR(themeDisplay.getUser()));
		jsonObject.put(NGHelperConstants.LR.AUTH_TOKEN, 
				AuthTokenUtil.getToken(PortalUtil.getHttpServletRequest(request)));
		
		return jsonObject;
	}
	

}
