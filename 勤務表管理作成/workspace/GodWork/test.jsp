<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html:html>
<body>
	start<br>
	<table border="1">
	<logic:iterate id="row" name="testActionForm" property="data">
	    <tr>
	    		<td><bean:write name="row" property="user_id"/></td>
				<td><bean:write name="row" property="work_date"/></td>
		</tr>
	</logic:iterate>
	</table>
	end<br>
</body>
</html:html>