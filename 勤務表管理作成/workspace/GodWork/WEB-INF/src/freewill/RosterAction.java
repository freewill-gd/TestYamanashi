package freewill;
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
		RosterDataAccess data = new RosterDataAccess();
		rosterActionForm.setData(data.getData(rosterActionForm.getYear() + rosterActionForm.getMonth()));
		request.setAttribute("rosterActionForm", rosterActionForm);
		return map.findForward("success");
  }

}