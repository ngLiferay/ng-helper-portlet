<%@ include file="/html/common/themes/init.jsp" %>

<script type="text/javascript">
	// <![CDATA[
		var Liferay = {
			themeDisplay: {
				isSignedIn: <%= themeDisplay.isSignedIn() %>,
				scopeGroupId: <%= themeDisplay.getScopeGroupId() %>,
				companyId: <%= themeDisplay.getCompanyId() %>,
				companyGroupId: <%= themeDisplay.getCompanyGroupId() %>,
				user: <%= JSONFactoryUtil.createJSONObject(JSONFactoryUtil.createJSONSerializer()
						.serialize(themeDisplay.getUser())).toString() %>,
				languageId: "<%= themeDisplay.getLanguageId() %>",
				authToken : '<%= AuthTokenUtil.getToken(request) %>'
			}	
		};


	// ]]>
</script>
