package freewill.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import freewill.bean.LoginBean;


public class LoginAction extends Action {
	
	public ActionForward execute (
			ActionMapping map, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
			
			try {
				LoginBean loginBean = (LoginBean)form;
				
				request.setAttribute("loginBean", loginBean);
				if (loginBean.getUserId().equals("fw001")) {
					return map.findForward("ok");
				}
				return map.findForward("success");
			}
			catch (Exception e)  {
				System.err.println(e.getMessage());
				return map.findForward("failure");
			}
		}


}
