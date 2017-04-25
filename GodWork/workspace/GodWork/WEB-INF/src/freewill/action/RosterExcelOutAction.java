package freewill.action;

import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
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
import org.omg.CORBA_2_3.portable.OutputStream;

import freewill.bean.RosterBean;
import freewill.database.dataaccess.RosterDataAccess;
import freewill.database.dto.RosterDto;

/**
 * 勤務表アクション
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

			/* データを取得して表示 */
			//getPage(request, rosterBean, session);
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=test.txt");
			ServletOutputStream os = response.getOutputStream();
			byte[] b = {0x41, 0x42};
			os.write(b);
			os.flush();
			os.close();
			
			return null;
		}
		catch (Exception e)  {
			System.err.println(e.getMessage());
			return map.findForward("failure");
		}
	}

	/**
	 *  勤務表表示
	 * @param request
	 * @param rosterBean
	 */
	private void getPage(HttpServletRequest request,
			RosterBean rosterBean, HttpSession session) {
		

		RosterDataAccess data = new RosterDataAccess();

		String start = rosterBean.getYear() + rosterBean.getMonth();
		RosterDto[] rosterDtos = data.getData(start, session.getAttribute("userId").toString());
		for(RosterDto dto : rosterDtos) {
			System.out.println(dto.getRemarks());
		}
		

	}
	

}