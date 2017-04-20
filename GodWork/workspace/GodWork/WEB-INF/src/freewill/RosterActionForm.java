package freewill;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import org.apache.struts.action.ActionForm;
import freewill.database.RosterDto;

public final class RosterActionForm extends ActionForm {
	private static final long serialVersionUID = 1L;

	private String year;
	private String month;
	private String name;
	private LinkedHashMap<String, String> selectYear;
	private LinkedHashMap<String, String> selectMonth;
	private LinkedHashMap<String, String> selectWorkKind;
	private String aMode;
	private String timeString;

	private String debugString = "デバッグ文字列";

	public String getDebugString() {
		return debugString;
	}

	public void setDebugString(String debugString) {
		this.debugString = debugString;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public String getaMode() {
		return aMode;
	}

	public void setaMode(String aMode) {
		this.aMode = aMode;
	}

	private RosterDto data[];

	public RosterActionForm() {
		Date now = new Date();
		year =   (new SimpleDateFormat("yyyy")).format(now);
		month = (new SimpleDateFormat("MM")).format(now);
		name = "テスト太郎";
		timeString = "?time=" + String.valueOf(now.getTime());

		data = new RosterDto[31];
		for (int i = 0; i < 31; i++) {
				data[i] = new RosterDto();
		}
	}

	public void setSelectYear(LinkedHashMap<String, String> selectYear) {
		this.selectYear = selectYear;
	}

	public LinkedHashMap<String, String> getSelectYear() {
		return selectYear;
	}

	public LinkedHashMap<String, String> getSelectMonth() {
		return selectMonth;
	}

	public void setSelectMonth(LinkedHashMap<String, String> selectMonth) {
		this.selectMonth = selectMonth;
	}

	public LinkedHashMap<String, String> getSelectWorkKind() {
		return selectWorkKind;
	}

	public void setSelectWorkKind(LinkedHashMap<String, String> selectWorkKind) {
		this.selectWorkKind = selectWorkKind;
	}

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

	public RosterDto[] getData() {
		if ( data != null) return data;

		data = new RosterDto[31];
		for (int i = 0; i < 31; i++) {
				data[i] = new RosterDto();
		}
		 return data;
	}

	public void setData(RosterDto[] data) {
		this.data = data;
	}

	public RosterDto getData(int index) {
		/* TODOインデックス範囲チェック未実装 */
		if(data == null) return  new RosterDto();
		return data[index];
	}

	public void setData(int index, RosterDto[] data) {
		/* TODOインデックス範囲チェック未実装  */
		if(data == null) return;
		this.data[index] = data[index];
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}