package com.liferaying.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JournalArticleServicesServiceClp
    implements JournalArticleServicesService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;

    public JournalArticleServicesServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getFoldersAndArticles";

        _methodParameterTypes3 = new String[] {
                "long", "long", "int", "int", "java.lang.String", "boolean"
            };

        _methodName4 = "getFoldersAndArticlesCount";

        _methodParameterTypes4 = new String[] { "long", "long" };

        _methodName5 = "getArticles";

        _methodParameterTypes5 = new String[] {
                "long", "long", "int", "int", "java.lang.String", "boolean"
            };

        _methodName6 = "getArticlesCount";

        _methodParameterTypes6 = new String[] { "long", "long" };

        _methodName7 = "searchArticles";

        _methodParameterTypes7 = new String[] {
                "long", "long", "java.util.List", "long", "java.lang.String",
                "java.lang.String", "java.lang.String",
                "java.util.LinkedHashMap", "int", "int",
                "com.liferay.portal.kernel.search.Sort"
            };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public java.util.List<java.lang.Object> getFoldersAndArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        groupId,
                        
                    folderId,
                        
                    start,
                        
                    end,
                        
                    ClpSerializer.translateInput(orderByCol),
                        
                    isAscending
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<java.lang.Object>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getFoldersAndArticlesCount(long groupId, long folderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4, new Object[] { groupId, folderId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    @Override
    public java.util.List<com.liferay.portlet.journal.model.JournalArticle> getArticles(
        long groupId, long folderId, int start, int end,
        java.lang.String orderByCol, boolean isAscending)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        groupId,
                        
                    folderId,
                        
                    start,
                        
                    end,
                        
                    ClpSerializer.translateInput(orderByCol),
                        
                    isAscending
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.liferay.portlet.journal.model.JournalArticle>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public int getArticlesCount(long groupId, long folderId)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6, new Object[] { groupId, folderId });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    @Override
    public com.liferay.portal.kernel.search.Hits searchArticles(
        long companyId, long groupId, java.util.List<java.lang.Long> folderIds,
        long classNameId, java.lang.String ddmStructureKey,
        java.lang.String ddmTemplateKey, java.lang.String keywords,
        java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
        int start, int end, com.liferay.portal.kernel.search.Sort sort)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName7,
                    _methodParameterTypes7,
                    new Object[] {
                        companyId,
                        
                    groupId,
                        
                    ClpSerializer.translateInput(folderIds),
                        
                    classNameId,
                        
                    ClpSerializer.translateInput(ddmStructureKey),
                        
                    ClpSerializer.translateInput(ddmTemplateKey),
                        
                    ClpSerializer.translateInput(keywords),
                        
                    ClpSerializer.translateInput(params),
                        
                    start,
                        
                    end,
                        
                    ClpSerializer.translateInput(sort)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.kernel.search.Hits) ClpSerializer.translateOutput(returnObj);
    }
}
