package com.liferaying.util;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.theme.ThemeDisplay;

import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ResourceRequest;

import org.apache.commons.lang3.math.NumberUtils;

public class NGHelperUtil {
	
	
	public static ThemeDisplay getThemeDisplay(ResourceRequest request) {
		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	
	public static JSONObject serializeLR(BaseModel<?> model) throws JSONException {
		JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
		return JSONFactoryUtil.createJSONObject(jsonSerializer.serialize(model));
	}
	
	public static JSONObject serialize(BaseModel<?> model) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		Map<String, Object> map = model.getModelAttributes();
		for (Entry<String, Object> entry : map.entrySet()) {
			String value = "";
			if(Validator.isNotNull(entry.getValue())){
				value = entry.getValue().toString();
				if (NumberUtils.isNumber(value)) {
					jsonObject.put(entry.getKey(), Long.valueOf(value));
				} 
				else if("true".equals(value) || "false".equals(value)){
					jsonObject.put(entry.getKey(), Boolean.valueOf(value));
				}
				else {
					jsonObject.put(entry.getKey(), value);
				}
			}
		}
		return jsonObject;
	}
}
