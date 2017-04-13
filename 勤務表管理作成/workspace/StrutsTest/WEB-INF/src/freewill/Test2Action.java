package freewill;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class Test2Action extends Action {

	@Override
	public ActionForward execute (
		ActionMapping map, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		//response.setContentType("text/html; charset=UTF-8");
		//response.setCharacterEncoding("UTF-8");

		Test2ActionForm test2ActionForm = (Test2ActionForm)form;
		String aaa = test2ActionForm.getText();
		System.out.println(aaa);
		aaa = aaa + "|";
		Date dt = new Date();
		test2ActionForm.setHoge(dt.toString());
		//test2ActionForm.setText(aaa);
		request.setAttribute("test2ActionForm", test2ActionForm);
		return map.findForward("success");
  }

}