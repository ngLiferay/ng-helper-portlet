package com.liferaying.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NGServicesService}.
 *
 * @author Brian Wing Shun Chan
 * @see NGServicesService
 * @generated
 */
public class NGServicesServiceWrapper implements NGServicesService,
    ServiceWrapper<NGServicesService> {
    private NGServicesService _ngServicesService;

    public NGServicesServiceWrapper(NGServicesService ngServicesService) {
        _ngServicesService = ngServicesService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _ngServicesService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _ngServicesService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _ngServicesService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getMethodNamesAndParams()
        throws java.lang.Exception {
        return _ngServicesService.getMethodNamesAndParams();
    }

    @Override
    public com.liferay.portal.kernel.json.JSONObject getContextServices(
        java.lang.String contextPath, java.lang.String services)
        throws java.lang.Exception {
        return _ngServicesService.getContextServices(contextPath, services);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public NGServicesService getWrappedNGServicesService() {
        return _ngServicesService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedNGServicesService(NGServicesService ngServicesService) {
        _ngServicesService = ngServicesService;
    }

    @Override
    public NGServicesService getWrappedService() {
        return _ngServicesService;
    }

    @Override
    public void setWrappedService(NGServicesService ngServicesService) {
        _ngServicesService = ngServicesService;
    }
}
