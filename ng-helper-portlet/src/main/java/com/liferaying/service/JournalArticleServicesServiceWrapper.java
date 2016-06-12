package com.liferaying.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JournalArticleServicesService}.
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleServicesService
 * @generated
 */
public class JournalArticleServicesServiceWrapper
    implements JournalArticleServicesService,
        ServiceWrapper<JournalArticleServicesService> {
    private JournalArticleServicesService _journalArticleServicesService;

    public JournalArticleServicesServiceWrapper(
        JournalArticleServicesService journalArticleServicesService) {
        _journalArticleServicesService = journalArticleServicesService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _journalArticleServicesService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _journalArticleServicesService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _journalArticleServicesService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public java.util.List<java.lang.Object> getFoldersAndArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _journalArticleServicesService.getFoldersAndArticles(groupId,
            folderId, start, end, orderByCol, isAscending);
    }

    @Override
    public int getFoldersAndArticlesCount(long groupId, long folderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _journalArticleServicesService.getFoldersAndArticlesCount(groupId,
            folderId);
    }

    @Override
    public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _journalArticleServicesService.getArticles(groupId, folderId,
            start, end, orderByCol, isAscending);
    }

    @Override
    public int getArticlesCount(long groupId, long folderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _journalArticleServicesService.getArticlesCount(groupId, folderId);
    }

    @Override
    public com.liferay.portal.kernel.search.Hits searchArticles(
        long companyId, long groupId, java.util.List<java.lang.Long> folderIds,
        long classNameId, java.lang.String ddmStructureKey,
        java.lang.String ddmTemplateKey, java.lang.String keywords,
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
        int start, int end, com.liferay.portal.kernel.search.Sort sort)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _journalArticleServicesService.searchArticles(companyId,
            groupId, folderIds, classNameId, ddmStructureKey, ddmTemplateKey,
            keywords, params, start, end, sort);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JournalArticleServicesService getWrappedJournalArticleServicesService() {
        return _journalArticleServicesService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJournalArticleServicesService(
        JournalArticleServicesService journalArticleServicesService) {
        _journalArticleServicesService = journalArticleServicesService;
    }

    @Override
    public JournalArticleServicesService getWrappedService() {
        return _journalArticleServicesService;
    }

    @Override
    public void setWrappedService(
        JournalArticleServicesService journalArticleServicesService) {
        _journalArticleServicesService = journalArticleServicesService;
    }
}
