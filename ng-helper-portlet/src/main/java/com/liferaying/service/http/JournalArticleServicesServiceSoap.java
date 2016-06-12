package com.liferaying.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferaying.service.JournalArticleServicesServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferaying.service.JournalArticleServicesServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticleServicesServiceHttp
 * @see com.liferaying.service.JournalArticleServicesServiceUtil
 * @generated
 */
public class JournalArticleServicesServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(JournalArticleServicesServiceSoap.class);

    public static int getFoldersAndArticlesCount(long groupId, long folderId)
        throws RemoteException {
        try {
            int returnValue = JournalArticleServicesServiceUtil.getFoldersAndArticlesCount(groupId,
                    folderId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.journal.model.JournalArticle[] getArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws RemoteException {
        try {
            java.util.List<com.liferay.portlet.journal.model.JournalArticle> returnValue =
                JournalArticleServicesServiceUtil.getArticles(groupId,
                    folderId, start, end, orderByCol, isAscending);

            return returnValue.toArray(new com.liferay.portlet.journal.model.JournalArticle[returnValue.size()]);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int getArticlesCount(long groupId, long folderId)
        throws RemoteException {
        try {
            int returnValue = JournalArticleServicesServiceUtil.getArticlesCount(groupId,
                    folderId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
