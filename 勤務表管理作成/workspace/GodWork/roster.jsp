<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html:html>
<body>
	<div>勤務表</div>
	<table border="1">
		 <tr>
			<td>work_date</td>
			<td>work_kind</td>
			<td>start_time</td>
			<td>end_time</td>
			<td>break_time</td>
			<td>over_time</td>
			<td>late_night_over_time</td>
			<td>holiday_over_time</td>
			<td>holiday_late_night_over_time</td>
			<td>remarks</td>
		</tr>
	<logic:iterate id="row" name="rosterActionForm" property="data">
	    <tr>
			<td><bean:write name="row" property="work_date"/></td>
			<td><bean:write name="row" property="work_kind"/></td>
			<td><bean:write name="row" property="start_time"/></td>
			<td><bean:write name="row" property="end_time"/></td>
			<td><bean:write name="row" property="break_time"/></td>
			<td><bean:write name="row" property="over_time"/></td>
			<td><bean:write name="row" property="late_night_over_time"/></td>
			<td><bean:write name="row" property="holiday_over_time"/></td>
			<td><bean:write name="row" property="holiday_late_night_over_time"/></td>
			<td><bean:write name="row" property="remarks"/></td>
		</tr>
	</logic:iterate>
	</table>
	end<br>
</body>
</html:html>