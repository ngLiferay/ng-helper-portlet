package com.liferaying.util;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;
import com.liferaying.invoke.MethodParams;

import java.util.List;

import javax.portlet.ResourceRequest;

public class JournalArticleUtil {
	
	@MethodParams(names= {NGHelperConstants.TD.SCOPE_GROUP_ID, NGHelperConstants.JA.ARTICLE_ID,
			NGHelperConstants.JA.VERSION, NGHelperConstants.TD.LANGUAGE_ID})
	public static JSONObject getJournalArticleJSON(ResourceRequest request) throws Exception {
		ThemeDisplay themeDisplay = NGHelperUtil.getThemeDisplay(request);
		long groupId = ParamUtil.getLong(request, NGHelperConstants.TD.SCOPE_GROUP_ID);
		String articleId = ParamUtil.getString(request, NGHelperConstants.JA.ARTICLE_ID);
		double version = ParamUtil.getDouble(request, NGHelperConstants.JA.VERSION);
		String languageId = ParamUtil.getString(request, NGHelperConstants.TD.LANGUAGE_ID);
		
		return getArticleJSON(articleId, groupId, version, languageId, themeDisplay);
		
	}
	
	@MethodParams(names={NGHelperConstants.TD.SCOPE_GROUP_ID, NGHelperConstants.LR.START, NGHelperConstants.LR.END,
			NGHelperConstants.TD.LANGUAGE_ID, NGHelperConstants.JA.FOLDER_ID})
	public static JSONArray getJournalArticlesJSON(ResourceRequest request) throws Exception {
		
		ThemeDisplay themeDisplay = NGHelperUtil.getThemeDisplay(request);
		long groupId = ParamUtil.getLong(request, NGHelperConstants.TD.SCOPE_GROUP_ID);
		int start = ParamUtil.getInteger(request, NGHelperConstants.LR.START, QueryUtil.ALL_POS);
		int end = ParamUtil.getInteger(request, NGHelperConstants.LR.END, QueryUtil.ALL_POS);
		String languageId = ParamUtil.getString(request, NGHelperConstants.TD.LANGUAGE_ID);
		long folderId = ParamUtil.getLong(request, NGHelperConstants.JA.FOLDER_ID);
			
		return getArticlesJSON(JournalArticleServiceUtil.getArticles(groupId, folderId, start, end, null),
				languageId, themeDisplay);
	}
	
	private static JSONArray getArticlesJSON(List<JournalArticle> articles, String languageId, 
			ThemeDisplay themeDisplay) throws Exception{
		JSONArray array = JSONFactoryUtil.createJSONArray();
		for (JournalArticle article :articles ) {
			array.put(getArticleJSON(languageId, themeDisplay, article));
		}
		return array;
	}
	
	private static JSONObject getArticleJSON(String articleId, long groupId, double version, String languageId,
			ThemeDisplay themeDisplay) throws Exception {
		
		JournalArticle article = version == 0.0 ? JournalArticleServiceUtil.getArticle(groupId, articleId) :
			JournalArticleServiceUtil.getArticle(groupId, articleId, version);
		
		//TODO check article for other workflow statuses
		
		return getArticleJSON(languageId, themeDisplay, article);
	}

	private static JSONObject getArticleJSON(String languageId, ThemeDisplay themeDisplay, 
			JournalArticle article) throws Exception {
		String content = getTemplateContent(article, languageId, themeDisplay);
		
		if(Validator.isNotNull(content)){
			article.setContent(content);
		}
			
		JSONObject jsonObject = NGHelperUtil.serializeLR(article);		
		
		//TODO contentCurrentValue is exists after json serialization. Implement for this.
		
		return jsonObject;
	}
	
	private static String getTemplateContent(JournalArticle article, ThemeDisplay themeDisplay, 
			JSONObject jsonArticle) throws Exception{
		return getTemplateContent(article, LanguageUtil.getLanguageId(LocaleUtil.getDefault()), themeDisplay);
	}
	
	private static String getTemplateContent(JournalArticle article, String languageId,
			ThemeDisplay themeDisplay) throws Exception{
		String content = StringPool.BLANK;
		if(article.isTemplateDriven()){
			content = JournalArticleLocalServiceUtil.getArticleContent(
					article.getGroupId(), article.getArticleId(), article.getVersion(), StringPool.BLANK, 
					languageId, themeDisplay);
		}
		return content;
	}

}
