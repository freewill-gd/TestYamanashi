<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html:html>
<head>
	<link rel="stylesheet" href="./css/godwork.css?5" type="text/css" />
	<title><bean:message key="disp.login" /></title>
	<script type="text/javascript" src="./js/jquery-3.2.1.js"></script>
</head>
<body>
	<html:form>
		
		<div class="title">
			<bean:message key="title.roster" /><bean:message key="disp.login" />
		</div>
		<div class="login_div" >
			<table class="login_table">
				<tr>
					<td><bean:message key="disp.user_id" /></td>
					<td><html:text name="loginBean" property="userId" /></td>
				</tr>
				<tr>
					<td><bean:message key="disp.password" /></td>
					<td><html:password name="loginBean" property="password" /></td>
				</tr>
			</table>
			<p class="error">
				<html:errors />
			</p>
			<br>
		<html:submit><bean:message key="disp.login" /></html:submit>
		</div>
	</html:form>
</body>

</html:html>