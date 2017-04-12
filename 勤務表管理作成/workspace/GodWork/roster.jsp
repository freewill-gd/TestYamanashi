<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html:html>
<head>
	<link rel="stylesheet" href="./css/godwork.css" type="text/css" />
</head>
<body>
	<div class="title">勤務表</div>
	<table class="maintable">
		 <tr>
			<td class="work_date">work_date</td>
			<td class="weekday">weekday</td>
			<td class="work_kind">work_kind</td>
			<td class="start_time">start_time</td>
			<td class="end_time">end_time</td>
			<td class="break_time">break_time</td>
			<td class="over_time">over_time</td>
			<td class="late_night_over_time">late_night_over_time</td>
			<td class="holiday_over_time">holiday_over_time</td>
			<td class="holiday_late_night_over_time">holiday_late_night_over_time</td>
			<td class="remarks">remarks</td>
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