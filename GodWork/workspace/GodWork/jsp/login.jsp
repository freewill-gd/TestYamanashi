<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html:html>
<head>
	<link rel="stylesheet" href="./css/godwork.css" type="text/css" />
	<title><bean:message key="title.roster" /></title>
	<script type="text/javascript" src="./js/jquery-3.2.1.js"></script>
</head>
<body>
	<html:form>
		
		<p class="error">
				<html:errors />
		</p>
	
				<html:text name="loginBean" property="userId" /><br>
				<html:text name="loginBean" property="password" /><br>
				<html:submit />
	</html:form>
</body>

</html:html>