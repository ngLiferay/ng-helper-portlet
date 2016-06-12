package com.liferaying.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for JournalArticleServices. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleServicesServiceUtil
 * @see com.liferaying.service.base.JournalArticleServicesServiceBaseImpl
 * @see com.liferaying.service.impl.JournalArticleServicesServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalArticleServicesService extends BaseService,
    InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link JournalArticleServicesServiceUtil} to access the journal article services remote service. Add custom service methods to {@link com.liferaying.service.impl.JournalArticleServicesServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<java.lang.Object> getFoldersAndArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws com.liferay.portal.kernel.exception.SystemException;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getFoldersAndArticlesCount(long groupId, long folderId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws com.liferay.portal.kernel.exception.SystemException;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getArticlesCount(long groupId, long folderId)
        throws com.liferay.portal.kernel.exception.SystemException;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits searchArticles(
        long companyId, long groupId, java.util.List<java.lang.Long> folderIds,
        long classNameId, java.lang.String ddmStructureKey,
        java.lang.String ddmTemplateKey, java.lang.String keywords,
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
        int start, int end, com.liferay.portal.kernel.search.Sort sort)
        throws com.liferay.portal.kernel.exception.SystemException;
}
