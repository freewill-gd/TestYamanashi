package freewill;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class TestAction extends Action {

	public ActionForward execute (
		ActionMapping map, ActionForm form,
		HttpServletRequest request, HttpServletResponse response) {
		TestActionForm testActionForm = (TestActionForm)form;
		TestC testC = new TestC();
		testActionForm.setText(testC.getText());
		request.setAttribute("testActionForm", testActionForm);
		return map.findForward("success");
  }

}