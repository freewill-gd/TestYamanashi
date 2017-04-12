<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html:html>
<head>
	<link rel="stylesheet" href="./css/godwork.css" type="text/css" />
	<title><bean:message key="title.roster" /></title>
</head>
<body>
	<div class="title">
			<bean:message key="title.roster" />
			<bean:write name="rosterActionForm" property="year"/>
			<bean:message key="disp.year" />
			<bean:write name="rosterActionForm" property="month"/>
			<bean:message key="disp.month" />
	</div>
	<div class="subtitle">
		<bean:message key="disp.name" />:<bean:write name="rosterActionForm" property="name"/>
	</div>
	<table class="maintable">
		 <tr>
			<td class="work_date"><bean:message key="disp.work_date" /></td>
			<td class="weekday"><bean:message key="disp.weekday" /></td>
			<td class="work_kind"><bean:message key="disp.work_kind" /></td>
			<td class="start_time"><bean:message key="disp.start_time" /></td>
			<td class="end_time"><bean:message key="disp.end_time" /></td>
			<td class="break_time"><bean:message key="disp.break_time" /></td>
			<td class="over_time"><bean:message key="disp.over_time" /></td>
			<td class="late_night_over_time"><bean:message key="disp.late_night_over_time" /></td>
			<td class="holiday_over_time"><bean:message key="disp.holiday_over_time" /></td>
			<td class="holiday_late_night_over_time"><bean:message key="disp.holiday_late_night_over_time" /></td>
			<td class="remarks"><bean:message key="disp.remarks" /></td>
		</tr>
	<logic:iterate id="row" name="rosterActionForm" property="data">
	    <tr data-weekday = "<bean:write name="row" property="weekday"/>">
			<td><bean:write name="row" property="work_date"/></td>
			<td><bean:write name="row" property="weekday"/></td>
			<td><bean:write name="row" property="work_kind"/></td>
			<td><bean:write name="row" property="start_time"/></td>
			<td><bean:write name="row" property="end_time"/></td>
			<td><bean:write name="row" property="break_time"/></td>
			<td><bean:write name="row" property="over_time"/></td>
			<td><bean:write name="row" property="late_night_over_time"/></td>
			<td><bean:write name="row" property="holiday_over_time"/></td>
			<td><bean:write name="row" property="holiday_late_night_over_time"/></td>
			<td class="remarks_data"><bean:write name="row" property="remarks"/></td>
		</tr>
	</logic:iterate>
	</table>
</body>
</html:html>