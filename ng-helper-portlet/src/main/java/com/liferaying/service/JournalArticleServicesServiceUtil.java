package com.liferaying.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for JournalArticleServices. This utility wraps
 * {@link com.liferaying.service.impl.JournalArticleServicesServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleServicesService
 * @see com.liferaying.service.base.JournalArticleServicesServiceBaseImpl
 * @see com.liferaying.service.impl.JournalArticleServicesServiceImpl
 * @generated
 */
public class JournalArticleServicesServiceUtil {
    private static JournalArticleServicesService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferaying.service.impl.JournalArticleServicesServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static java.util.List<java.lang.Object> getFoldersAndArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getFoldersAndArticles(groupId, folderId, start, end,
            orderByCol, isAscending);
    }

    public static int getFoldersAndArticlesCount(long groupId, long folderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFoldersAndArticlesCount(groupId, folderId);
    }

    public static java.util.List<com.liferay.portlet.journal.model.JournalArticle> getArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getArticles(groupId, folderId, start, end, orderByCol,
            isAscending);
    }

    public static int getArticlesCount(long groupId, long folderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getArticlesCount(groupId, folderId);
    }

    public static com.liferay.portal.kernel.search.Hits searchArticles(
        long companyId, long groupId, java.util.List<java.lang.Long> folderIds,
        long classNameId, java.lang.String ddmStructureKey,
        java.lang.String ddmTemplateKey, java.lang.String keywords,
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
        int start, int end, com.liferay.portal.kernel.search.Sort sort)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .searchArticles(companyId, groupId, folderIds, classNameId,
            ddmStructureKey, ddmTemplateKey, keywords, params, start, end, sort);
    }

    public static void clearService() {
        _service = null;
    }

    public static JournalArticleServicesService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    JournalArticleServicesService.class.getName());

            if (invokableService instanceof JournalArticleServicesService) {
                _service = (JournalArticleServicesService) invokableService;
            } else {
                _service = new JournalArticleServicesServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(JournalArticleServicesServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(JournalArticleServicesService service) {
    }
}
