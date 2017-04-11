package freewill;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

public final class TestActionForm extends ActionForm {
  private static final long serialVersionUID = 1L;

  public List<Map<String, Object>> data;

  public List<Map<String, Object>> getData() {
	return data;
}

public void setData(List<Map<String, Object>> data) {
	this.data = data;
}

private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}