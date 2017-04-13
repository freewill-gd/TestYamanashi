package freewill;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

public final class RosterActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String year = "2017";
	private String month = "07";
	private String name = "テスト太郎";
	private LinkedHashMap<String, String> selectYear;

	public List<Map<String, Object>> data;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public List<Map<String, Object>> getData() {
		return data;
	}

	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSelectYear(LinkedHashMap<String, String> selectYear) {
		this.selectYear = selectYear;
	}

	public LinkedHashMap<String, String> getSelectYear() {
		return selectYear;
	}
}