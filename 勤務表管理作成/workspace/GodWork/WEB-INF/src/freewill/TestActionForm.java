package freewill;
import org.apache.struts.action.ActionForm;

public final class TestActionForm extends ActionForm {
  private static final long serialVersionUID = 1L;

  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}