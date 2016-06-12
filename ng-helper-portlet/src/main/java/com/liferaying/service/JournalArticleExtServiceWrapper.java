package com.liferaying.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link JournalArticleExtService}.
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleExtService
 * @generated
 */
public class JournalArticleExtServiceWrapper implements JournalArticleExtService,
    ServiceWrapper<JournalArticleExtService> {
    private JournalArticleExtService _journalArticleExtService;

    public JournalArticleExtServiceWrapper(
        JournalArticleExtService journalArticleExtService) {
        _journalArticleExtService = journalArticleExtService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _journalArticleExtService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _journalArticleExtService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _journalArticleExtService.invokeMethod(name, parameterTypes,
            arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public JournalArticleExtService getWrappedJournalArticleExtService() {
        return _journalArticleExtService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedJournalArticleExtService(
        JournalArticleExtService journalArticleExtService) {
        _journalArticleExtService = journalArticleExtService;
    }

    @Override
    public JournalArticleExtService getWrappedService() {
        return _journalArticleExtService;
    }

    @Override
    public void setWrappedService(
        JournalArticleExtService journalArticleExtService) {
        _journalArticleExtService = journalArticleExtService;
    }
}
