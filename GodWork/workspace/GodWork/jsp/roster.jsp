<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html:html>
<head>
	<link rel="stylesheet" href="./css/godwork.css<bean:write name="rosterBean" property="timeString"/>" type="text/css" />
	<title><bean:message key="title.roster" /></title>
	<script type="text/javascript" src="./js/jquery-3.2.1.js<bean:write name="rosterBean" property="timeString"/>"></script>
	<script type="text/javascript" src="./js/roster.js<bean:write name="rosterBean" property="timeString"/>"></script>
</head>
<body>
	<html:form action="/Roster.do">
		<input type="hidden" id="actionMode" name="actionMode" />
		<p class="error">
				<html:errors />
		</p>
		<div class="input_arear">
			<html:select name="rosterBean" property="year">
				<html:optionsCollection name="rosterBean" property="selectYear" value="key" label="value" />
			</html:select>
			<bean:message key="disp.year" />
			<html:select name="rosterBean" property="month">
				<html:optionsCollection name="rosterBean" property="selectMonth" value="key" label="value" />
			</html:select>
			<bean:message key="disp.month" />
			<button type="button"  onclick="move();"><bean:message key="disp.move" /></button>
			<button type="button"  onclick="update();"><bean:message key="disp.save" /></button>
			<button type="button"  onclick="excel();"><bean:message key="disp.excel" /></button>
		</div>
		<div class="title">
			<bean:message key="title.roster" />
			<bean:write name="rosterBean" property="year"/>
			<bean:message key="disp.year" />
			<bean:write name="rosterBean" property="month"/>
			<bean:message key="disp.month" />
		</div>
		<div class="subtitle">
			<bean:message key="disp.name" />:<bean:write name="rosterBean" property="name"/>
		</div>
		<table class="maintable">
			 <tr>
				<td class="work_date"><bean:message key="disp.work_date" /></td>
				<td class="weekday"><bean:message key="disp.weekday" /></td>
				<td class="def"><bean:message key="disp.weekday" /></td>
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
		<logic:iterate id="data" name="rosterBean" property="data" >
		    <tr data-weekday = "<bean:write name="data" property="weekday"/>">
				<td><html:hidden name="data"  property="workDateKey"  indexed="true" /><bean:write name="data" property="workDate"/></td>
				<td><bean:write name="data" property="weekday"/></td>
				<td><button type="button" data-work-date = "<bean:write name="data" property="workDate"/>">○</button></td>
				<td>
					<html:select name="data" property="workKind" indexed="true">
						<html:optionsCollection name="rosterBean" property="selectWorkKind" value="key" label="value" />
					</html:select>
				</td>
				<td><html:text name="data" property="startTime"  indexed="true" styleClass="time_text"/></td>
				<td><html:text name="data" property="endTime" indexed="true" styleClass="time_text"/></td>
				<td><html:text name="data" property="breakTime" indexed="true" styleClass="time_text"/></td>
				<td><html:text name="data" property="overTime" indexed="true" styleClass="time_text"/></td>
				<td><html:text name="data" property="lateNightOverTime" indexed="true" styleClass="time_text"/></td>
				<td><html:text name="data" property="holidayOverTime" indexed="true" styleClass="time_text"/></td>
				<td><html:text name="data" property="holidayLateNightOverTime" indexed="true" styleClass="time_text"/></td>
				<td ><html:text name="data" property="remarks" indexed="true" styleClass="remarks_text"/></td>
			</tr>
		</logic:iterate>
		</table>
	</html:form>
</body>

</html:html>