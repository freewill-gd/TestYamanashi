package freewill;

import org.apache.struts.action.ActionForm;

public final class Test2ActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private static int a = 1;

	private String text;

	private String hoge;

	public String getHoge() {
		return hoge;
	}
	public void setHoge(String hoge) {
		this.hoge = hoge;
	}
	public Test2ActionForm() {
		a++;
		System.out.println(a);
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}