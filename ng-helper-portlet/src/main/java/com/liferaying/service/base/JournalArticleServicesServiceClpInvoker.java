package com.liferaying.service.base;

import com.liferaying.service.JournalArticleServicesServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class JournalArticleServicesServiceClpInvoker {
    private String _methodName28;
    private String[] _methodParameterTypes28;
    private String _methodName29;
    private String[] _methodParameterTypes29;
    private String _methodName32;
    private String[] _methodParameterTypes32;
    private String _methodName33;
    private String[] _methodParameterTypes33;
    private String _methodName34;
    private String[] _methodParameterTypes34;
    private String _methodName35;
    private String[] _methodParameterTypes35;
    private String _methodName36;
    private String[] _methodParameterTypes36;

    public JournalArticleServicesServiceClpInvoker() {
        _methodName28 = "getBeanIdentifier";

        _methodParameterTypes28 = new String[] {  };

        _methodName29 = "setBeanIdentifier";

        _methodParameterTypes29 = new String[] { "java.lang.String" };

        _methodName32 = "getFoldersAndArticles";

        _methodParameterTypes32 = new String[] {
                "long", "long", "int", "int", "java.lang.String", "boolean"
            };

        _methodName33 = "getFoldersAndArticlesCount";

        _methodParameterTypes33 = new String[] { "long", "long" };

        _methodName34 = "getArticles";

        _methodParameterTypes34 = new String[] {
                "long", "long", "int", "int", "java.lang.String", "boolean"
            };

        _methodName35 = "getArticlesCount";

        _methodParameterTypes35 = new String[] { "long", "long" };

        _methodName36 = "searchArticles";

        _methodParameterTypes36 = new String[] {
                "long", "long", "java.util.List", "long", "java.lang.String",
                "java.lang.String", "java.lang.String",
                "java.util.LinkedHashMap", "int", "int",
                "com.liferay.portal.kernel.search.Sort"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName28.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
            return JournalArticleServicesServiceUtil.getBeanIdentifier();
        }

        if (_methodName29.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
            JournalArticleServicesServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName32.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
            return JournalArticleServicesServiceUtil.getFoldersAndArticles(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                (java.lang.String) arguments[4],
                ((Boolean) arguments[5]).booleanValue());
        }

        if (_methodName33.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
            return JournalArticleServicesServiceUtil.getFoldersAndArticlesCount(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            return JournalArticleServicesServiceUtil.getArticles(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                ((Integer) arguments[3]).intValue(),
                (java.lang.String) arguments[4],
                ((Boolean) arguments[5]).booleanValue());
        }

        if (_methodName35.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
            return JournalArticleServicesServiceUtil.getArticlesCount(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue());
        }

        if (_methodName36.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
            return JournalArticleServicesServiceUtil.searchArticles(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.util.List<java.lang.Long>) arguments[2],
                ((Long) arguments[3]).longValue(),
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.util.LinkedHashMap<java.lang.String, java.lang.Object>) arguments[7],
                ((Integer) arguments[8]).intValue(),
                ((Integer) arguments[9]).intValue(),
                (com.liferay.portal.kernel.search.Sort) arguments[10]);
        }

        throw new UnsupportedOperationException();
    }
}
