package com.liferaying.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for NGServices. This utility wraps
 * {@link com.liferaying.service.impl.NGServicesServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see NGServicesService
 * @see com.liferaying.service.base.NGServicesServiceBaseImpl
 * @see com.liferaying.service.impl.NGServicesServiceImpl
 * @generated
 */
public class NGServicesServiceUtil {
    private static NGServicesService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferaying.service.impl.NGServicesServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.portal.kernel.json.JSONObject getMethodNamesAndParams()
        throws java.lang.Exception {
        return getService().getMethodNamesAndParams();
    }

    public static com.liferay.portal.kernel.json.JSONObject getContextServices(
        java.lang.String contextPath, java.lang.String services)
        throws java.lang.Exception {
        return getService().getContextServices(contextPath, services);
    }

    public static void clearService() {
        _service = null;
    }

    public static NGServicesService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    NGServicesService.class.getName());

            if (invokableService instanceof NGServicesService) {
                _service = (NGServicesService) invokableService;
            } else {
                _service = new NGServicesServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(NGServicesServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(NGServicesService service) {
    }
}
