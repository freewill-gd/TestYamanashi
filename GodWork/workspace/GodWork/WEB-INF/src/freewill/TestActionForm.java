package freewill;

import org.apache.struts.action.ActionForm;

import freewill.database.RosterDto;

public final class TestActionForm extends ActionForm {
  private static final long serialVersionUID = 1L;

  public RosterDto[] data;

  public RosterDto[] getData() {
	return data;
}

public void setData(RosterDto[] data) {
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