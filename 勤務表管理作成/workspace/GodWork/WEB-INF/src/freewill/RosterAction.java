package freewill;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import freewill.database.RosterDataAccess;
import freewill.database.RosterDto;

public final class RosterAction extends Action {

	public ActionForward execute (
		ActionMapping map, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {

		try {
			RosterActionForm rosterActionForm = (RosterActionForm)form;
			if(rosterActionForm != null) {
				if (rosterActionForm.getaMode() != null  && rosterActionForm.getaMode().equals("update")){
					update(rosterActionForm);
				}
			}

			getPage(request, rosterActionForm);
			return map.findForward("success");
		}
		catch(Exception e)  {
			return map.findForward("failure");
		}

  }

	/**
	 * 勤務表更新
	 * @param rosterActionForm
	 */
	private void update(RosterActionForm rosterActionForm) {
		RosterDataAccess da = new RosterDataAccess();
		for(RosterDto dto: rosterActionForm.getData()) {
				dto.setUserId("fw001");
		}
		da.updates( rosterActionForm.getData());
	}

	/**
	 *  勤務表表示
	 * @param request
	 * @param rosterActionForm
	 */
	private void getPage(HttpServletRequest request,
			RosterActionForm rosterActionForm) {
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

		LinkedHashMap<String, String> selectWorkKind = new LinkedHashMap<String, String>();
		selectWorkKind.put("0","");
		selectWorkKind.put("1","通常勤務");
		selectWorkKind.put("2","休日出勤");
		selectWorkKind.put("3","有給休暇");
		selectWorkKind.put("4","特別休暇");
		selectWorkKind.put("5","欠勤");

		rosterActionForm.setSelectYear(selectYear);
		rosterActionForm.setSelectMonth(selectMonth);
		rosterActionForm.setSelectWorkKind(selectWorkKind);

		RosterDataAccess data = new RosterDataAccess();

		String start = rosterActionForm.getYear() + rosterActionForm.getMonth();
		rosterActionForm.setData(data.getData(start));
		request.setAttribute("rosterActionForm", rosterActionForm);
	}

}