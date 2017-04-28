package freewill.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.struts.action.ActionForm;

import freewill.database.dto.RosterDto;

/**
 * 勤務表フォーム
 * @author Tomoyuki Yamanashi
 *
 */
public final class RosterBean extends ActionForm {
	private static final long serialVersionUID = 1L;

	/**
	 * コンボ年
	 */
	private String year;
	
	/**
	 * コンボ月
	 */
	private String month;
	
	/**
	 * ログイン名
	 */
	private String name;
	
	/**
	 * 勤務表データ
	 */
	private RosterDto data[];
	
	/**
	 * コンボ年（リスト内容）
	 */
	private LinkedHashMap<String, String> selectYear;
	
	/**
	 * コンボ月（リスト内容）
	 */
	private LinkedHashMap<String, String> selectMonth;
	
	/**
	 * コンボ勤務種別（リスト内容）
	 */
	private LinkedHashMap<String, String> selectWorkKind;
	
	/**
	 * アクションモード
	 * 移動、保存、Excel出力を判断する
	 */
	private String actionMode;
	
	/**
	 * キャッシュ対策用の時間
	 */
	private String timeString;

	public RosterBean() {
		Date now = new Date();
		year =   (new SimpleDateFormat("yyyy")).format(now);
		month = (new SimpleDateFormat("MM")).format(now);
		name = "";
		timeString = "?time=" + String.valueOf(now.getTime());

		data = new RosterDto[31];
		for (int i = 0; i < 31; i++) {
				data[i] = new RosterDto();
		}
	}

	public String getActionMode() {
		return actionMode;
	}

	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
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

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

}