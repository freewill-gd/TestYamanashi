package freewill;

import java.util.Date;

import org.apache.struts.action.ActionForm;

public final class Test2ActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private static int a = 1;

	private String text;

	private String hoge;

	private int yyy;

	public Date getDt() {
		return dt;
	}
	public void setDt(Date dt) {
		this.dt = dt;
	}

	private Date dt;

	public int getYyy() {
		return yyy;
	}
	public void setYyy(int yyy) {
		this.yyy = yyy;
	}
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