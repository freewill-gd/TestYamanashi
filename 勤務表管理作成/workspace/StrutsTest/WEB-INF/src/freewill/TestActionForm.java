package freewill;
import java.util.Map;

import org.apache.struts.action.ActionForm;

public final class TestActionForm extends ActionForm {
  private static final long serialVersionUID = 1L;

  private String[][] strs = {{"As1","AAA1","SSS1"}, {"As2","AAA2","SSS2"}};

private Map<String,String> map;

  private String text;

  public TestActionForm() {
	  map.put("hoge", "あああ");
	  map.put("hoge2", "いいい");

  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

public void setStrs(String[][] strs) {
	this.strs = strs;
}

public String[][] getStrs() {
	return strs;
}

public void setMap(Map<String,String> map) {
	this.map = map;
}

public Map<String,String> getMap() {
	return map;
}
}