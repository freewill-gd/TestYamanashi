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
		<logic:iterate id="col" name="row" >
				<logic:equal name="col" property="key" value="work_date" >
					<td><bean:write name="col" property="value"/></td>
				</logic:equal>
				<logic:equal name="col" property="key" value="insert_user_id" >
					<td><bean:write name="col" property="value"/></td>
				</logic:equal>
		</logic:iterate>
		</tr>
	</logic:iterate>
	</table>
	end<br>
</body>
</html:html>