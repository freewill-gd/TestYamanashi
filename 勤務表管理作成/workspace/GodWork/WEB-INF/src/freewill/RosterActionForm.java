package freewill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.action.ActionForm;

public final class RosterActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String year;
	private String month;
	private String name;
	private LinkedHashMap<String, String> selectYear;
	private LinkedHashMap<String, String> selectMonth;

	public RosterActionForm() {
		Date now = new Date();
		year =   (new SimpleDateFormat("yyyy")).format(now);
		month = (new SimpleDateFormat("MM")).format(now);
		name = "テスト太郎";
	}

	public LinkedHashMap<String, String> getSelectMonth() {
		return selectMonth;
	}

	public void setSelectMonth(LinkedHashMap<String, String> selectMonth) {
		this.selectMonth = selectMonth;
	}

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