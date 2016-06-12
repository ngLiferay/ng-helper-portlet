package com.liferaying.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferaying.service.base.JournalArticleServicesServiceBaseImpl;
import com.liferaying.service.comparator.ArticleCreateDateComparator;
import com.liferaying.service.comparator.ArticleDisplayDateComparator;
import com.liferaying.service.comparator.ArticleIDComparator;
import com.liferaying.service.comparator.ArticleModifiedDateComparator;
import com.liferaying.service.comparator.ArticleReviewDateComparator;
import com.liferaying.service.comparator.ArticleTitleComparator;
import com.liferaying.service.comparator.ArticleVersionComparator;
import com.liferaying.service.comparator.FolderIdComparator;
import com.liferaying.util.NGHelperConstants;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * The implementation of the journal article services remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferaying.service.JournalArticleServicesService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferaying.service.base.JournalArticleServicesServiceBaseImpl
 * @see com.liferaying.service.JournalArticleServicesServiceUtil
 */
public class JournalArticleServicesServiceImpl
    extends JournalArticleServicesServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferaying.service.JournalArticleServicesServiceUtil} to access the journal article services remote service.
     */
	
	@AccessControlled(guestAccessEnabled=true)
	public List<Object> getFoldersAndArticles(long groupId, long folderId, int start, int end,
			String orderByCol, boolean isAscending) throws SystemException{
		
		return journalFolderService.getFoldersAndArticles(groupId, folderId, start, end, 
				getComparator(orderByCol, isAscending));
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public int getFoldersAndArticlesCount(long groupId, long folderId) throws SystemException{
		
		return journalFolderService.getFoldersAndArticlesCount(groupId, folderId);
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public List<JournalArticle> getArticles(long groupId, long folderId, int start, int end,
			String orderByCol, boolean isAscending) throws SystemException{
		
		return journalArticleService.getArticles(groupId, folderId, start, end, 
				getComparator(orderByCol, isAscending));
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public int getArticlesCount(long groupId, long folderId) throws SystemException{
		
		return journalFolderService.getFoldersAndArticlesCount(groupId, folderId);
	}

	@AccessControlled(guestAccessEnabled=true)
	public Hits searchArticles(
			long companyId, long groupId, List<Long> folderIds,
			long classNameId, String ddmStructureKey, String ddmTemplateKey,
			String keywords, LinkedHashMap<String, Object> params, int start,
			int end, Sort sort) throws SystemException{
		
		return journalArticleLocalService.search(companyId, groupId, folderIds, 
				classNameId, ddmStructureKey, ddmTemplateKey, keywords, 
				params, start, end, sort);
	}
	
	private OrderByComparator getComparator(String orderByCol, boolean isAscending) {
		OrderByComparator obc = null;
		if(Validator.isNotNull(orderByCol)){
			if(orderByCol.equals(NGHelperConstants.COMPARATORS.ARTICLE_ID)){
				obc = new ArticleIDComparator(isAscending);
			} 
			else if(orderByCol.equals(NGHelperConstants.COMPARATORS.ARTICLE_TITLE)){
				obc = new ArticleTitleComparator(isAscending);
			}
			else if(orderByCol.equals(NGHelperConstants.COMPARATORS.ARTICLE_VERSION)){
				obc = new ArticleVersionComparator(isAscending);
			} 
			else if(orderByCol.equals(NGHelperConstants.COMPARATORS.CREATE_DATE)){
				obc = new ArticleCreateDateComparator(isAscending);
			} 
			else if(orderByCol.equals(NGHelperConstants.COMPARATORS.DISPLAY_DATE)){
				obc = new ArticleDisplayDateComparator(isAscending);
			} 
			else if(orderByCol.equals(NGHelperConstants.COMPARATORS.FOLDER_ID)){
				obc = new FolderIdComparator(isAscending);
			} 
			else if(orderByCol.equals(NGHelperConstants.COMPARATORS.MODIFIED_DATE)){
				obc = new ArticleModifiedDateComparator(isAscending);
			} 
			else if(orderByCol.equals(NGHelperConstants.COMPARATORS.REVIEW_DATE)){
				obc = new ArticleReviewDateComparator(isAscending);
			} 
			
		}
		return obc;
	}
}
