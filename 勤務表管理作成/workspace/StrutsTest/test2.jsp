<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
	<link rel="stylesheet" href="css/test.css" type="text/css" />
</head>
<body>
   <div class="hoge" ></div>
	<bean:write name="test2ActionForm" property="hoge" />
	<html:form action="/Test2">
		<html:text  name="test2ActionForm" property="text"  styleClass="hoge"/>
		<html:text  name="test2ActionForm" property="dt"  styleClass="hoge"/>

	</html:form>
</body>
</html:html>