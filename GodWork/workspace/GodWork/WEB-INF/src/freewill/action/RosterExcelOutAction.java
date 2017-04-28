package freewill.action;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import freewill.bean.RosterBean;
import freewill.database.dataaccess.RosterDataAccess;
import freewill.database.dto.RosterDto;
import freewill.excel.RosterExcel;

/**
 * 勤務表Excelアクション
 * @author Tomoyuki Yamanashi
 *
 */
public final class RosterExcelOutAction extends Action {

	public ActionForward execute (
		ActionMapping map, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		try {
			RosterBean rosterBean = (RosterBean)form;
			String start = rosterBean.getYear() + rosterBean.getMonth();
			String userId = session.getAttribute("userId").toString();
			String userName = session.getAttribute("userName").toString();
			
			String fileName = "Roster(" +  userId + ")" + start + ".xlsx";
			
			RosterExcel excl = new RosterExcel();			
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			ServletOutputStream os = response.getOutputStream();

			excl.OutoutExcel(os, start, userId, userName);
			os.flush();
			os.close();
			
			return null;
		}
		catch (Exception e)  {
			System.err.println(e.getMessage());
			return map.findForward("failure");
		}
	}

}