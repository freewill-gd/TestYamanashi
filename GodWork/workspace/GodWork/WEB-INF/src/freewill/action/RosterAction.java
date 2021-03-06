package freewill.action;

import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

/**
 * 勤務表アクション
 * @author Tomoyuki Yamanashi
 *
 */
public final class RosterAction extends Action {

	public ActionForward execute (
		ActionMapping map, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		try {
			RosterBean rosterBean = (RosterBean)form;
			if(rosterBean != null &&
				rosterBean.getActionMode() != null  && 
				rosterBean.getActionMode().equals("update") &&
				checkInput(request, rosterBean)) {

				/* 更新 */
				update(rosterBean, session);
			}
			
			/* データを取得して表示 */
			getPage(request, rosterBean, session);
			
			return map.findForward("success");
		}
		catch (Exception e)  {
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
		if (rosterBean == null) return false;
		
		boolean okflg = true;

		for (RosterDto dto: rosterBean.getData()) {
			if (checkRoster(dto)) continue;
			okflg = false;
			break;
		}

		if (okflg) return true;
		
		ActionMessages msgs = new ActionMessages();
		msgs.add("test", new ActionMessage("error.timeformat"));
		saveErrors(request, msgs);
		
		return false;
	}

	/**
	 * 1行分のデータを検証
	 * @param dto
	 * @return
	 */
	private boolean checkRoster(RosterDto dto) {
		if (dto == null) return true;
		
		if (!checkTimeString(dto.getStartTime())) return false;
		if (!checkTimeString(dto.getEndTime())) return false;
		if (!checkTimeString(dto.getBreakTime())) return false;
		if (!checkTimeString(dto.getOverTime())) return false;
		if (!checkTimeString(dto.getLateNightOverTime())) return false;
		if (!checkTimeString(dto.getHolidayOverTime())) return false;
		if (!checkTimeString(dto.getHolidayLateNightOverTime())) return false;
	
		return true;
	}
	
	/**
	 * 時間パターン検証
	 * @param timestr
	 * @return
	 */
	private boolean checkTimeString(String timestr) {
		if (timestr == null) return true;
		if (timestr.length() == 0) return true;
		
		String regex = "^[0-9][0-9]:[0-5][0-9]$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(timestr);
		
		if (match.find()) return true;
		return false;
	}
	
	/**
	 * 勤務表更新
	 * @param rosterBean
	 */
	private void update(RosterBean rosterBean, HttpSession session) {
		RosterDataAccess da = new RosterDataAccess();
		for (RosterDto dto: rosterBean.getData()) {
				dto.setUserId(session.getAttribute("userId").toString());
		}
		da.updates( rosterBean.getData());
	}

	/**
	 *  勤務表表示
	 * @param request
	 * @param rosterBean
	 */
	private void getPage(HttpServletRequest request,
			RosterBean rosterBean, HttpSession session) {
		
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
		data.checkData(start, session.getAttribute("userId").toString());
		
		rosterBean.setData(data.getData(start, session.getAttribute("userId").toString()));
		rosterBean.setName(session.getAttribute("userName").toString());
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