package freewill.action;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.MessageResources;

import freewill.bean.RosterBean;
import freewill.database.dataaccess.RosterDataAccess;
import freewill.database.dto.RosterDto;

public final class RosterAction extends Action {

	public ActionForward execute (
		ActionMapping map, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		
		try {
			RosterBean rosterBean = (RosterBean)form;
			if(rosterBean != null) {
				if (rosterBean.getActionMode() != null  && rosterBean.getActionMode().equals("update")){
					if(checkInput(request, rosterBean)) {
						update(rosterBean);
					}
				}
			}
			
			getPage(request, rosterBean);
			return map.findForward("success");
		}
		catch(Exception e)  {
			System.err.println(e.getMessage());
			return map.findForward("failure");
		}
	}

	/**
	 * 入力値を検証
	 * @param request
	 * @param rosterBean
	 */
	private boolean checkInput(HttpServletRequest request, RosterBean rosterBean) {
		if(rosterBean == null) return false;
		boolean okflg = true;
		for(RosterDto dto: rosterBean.getData()) {
			if (dto == null) continue;
			if (dto.getWorkDateKey() == null) continue;
			if (dto.getStartTime() != null && dto.getStartTime().length() > 5) {
				okflg = false;
				break;
			}
			
		}
		
		if( okflg == false) {
			ActionMessages msgs = new ActionMessages();
			msgs.add("test", new ActionMessage("error.timeformat"));
			saveErrors(request, msgs);
		}
		
		return okflg;
	}

	/**
	 * 勤務表更新
	 * @param rosterBean
	 */
	private void update(RosterBean rosterBean) {
		RosterDataAccess da = new RosterDataAccess();
		for(RosterDto dto: rosterBean.getData()) {
				dto.setUserId("fw001");
		}
		da.updates( rosterBean.getData());
	}

	/**
	 *  勤務表表示
	 * @param request
	 * @param rosterBean
	 */
	private void getPage(HttpServletRequest request,
			RosterBean rosterBean) {
		
		LinkedHashMap<String, String> selectYear = createNumberMap(2015, 2025, "%04d");
		LinkedHashMap<String, String> selectMonth = createNumberMap(1, 12, "%02d");

		MessageResources resources = getResources(request);
		LinkedHashMap<String, String> selectWorkKind = new LinkedHashMap<String, String>();
		selectWorkKind.put("0","");
		selectWorkKind.put("1",resources.getMessage("work.regular_work"));
		selectWorkKind.put("2",resources.getMessage("work.holiday_work"));
		selectWorkKind.put("3",resources.getMessage("work.paid_holidays"));
		selectWorkKind.put("4",resources.getMessage("work.special_holiday"));
		selectWorkKind.put("5",resources.getMessage("work.absence"));

		rosterBean.setSelectYear(selectYear);
		rosterBean.setSelectMonth(selectMonth);
		rosterBean.setSelectWorkKind(selectWorkKind);

		RosterDataAccess data = new RosterDataAccess();

		String start = rosterBean.getYear() + rosterBean.getMonth();
		rosterBean.setData(data.getData(start));
		request.setAttribute("rosterBean", rosterBean);
	}
	
	/**
	 * 数字コンボボックス作成
	 * @param start
	 * @param end
	 * @param format
	 * @return
	 */
	private LinkedHashMap<String, String> createNumberMap(int start, int end, String format) {
		LinkedHashMap<String, String> ret = new LinkedHashMap<String, String>();
		for (int i = start; i <= end; i++) {
			String month = String.format(format, i);
			ret.put(month , month);
		}
		return ret;
	}

}