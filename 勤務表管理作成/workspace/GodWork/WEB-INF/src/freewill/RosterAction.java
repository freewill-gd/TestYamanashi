package freewill;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

 import freewill.database.RosterDataAccess;

public final class RosterAction extends Action {

	public ActionForward execute (
		ActionMapping map, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		RosterActionForm rosterActionForm = (RosterActionForm)form;

		LinkedHashMap<String, String> selectYear = new LinkedHashMap<String, String>();
		for (int i = 2015; i <= 2025; i++) {
			String year = String.valueOf(i);
			selectYear.put(year , year);
		}

		LinkedHashMap<String, String> selectMonth = new LinkedHashMap<String, String>();
		for (int i = 1; i <= 12; i++) {
			String month = String.format("%02d", i);
			selectMonth.put(month , month);
		}

		rosterActionForm.setSelectYear(selectYear);
		rosterActionForm.setSelectMonth(selectMonth);

		RosterDataAccess data = new RosterDataAccess();

		String start = rosterActionForm.getYear() + rosterActionForm.getMonth();
		rosterActionForm.setData(data.getData(start));
		request.setAttribute("rosterActionForm", rosterActionForm);
		return map.findForward("success");
  }

}