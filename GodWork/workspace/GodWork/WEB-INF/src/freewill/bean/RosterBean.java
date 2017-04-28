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
	
	/**
	 * コンボ年
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * コンボ年
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * コンボ月
	 * @return
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * コンボ月
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ログイン名
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * ログイン名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 勤務表データ
	 * @return
	 */
	public RosterDto[] getData() {
		if ( data != null) return data;

		data = new RosterDto[31];
		for (int i = 0; i < 31; i++) {
				data[i] = new RosterDto();
		}
		 return data;
	}

	/**
	 * 勤務表データ
	 * @param data
	 */
	public void setData(RosterDto[] data) {
		this.data = data;
	}

	/**
	 * 勤務表データ
	 * @param index
	 * @return
	 */
	public RosterDto getData(int index) {
		if(data == null) return  new RosterDto();
		return data[index];
	}

	/**
	 * 勤務表データ
	 * @param index
	 * @param data
	 */
	public void setData(int index, RosterDto[] data) {
		if(data == null) return;
		this.data[index] = data[index];
	}

	/**
	 * コンボ年（リスト内容）
	 * @return
	 */
	public LinkedHashMap<String, String> getSelectYear() {
		return selectYear;
	}

	/**
	 * コンボ年（リスト内容）
	 * @param selectYear
	 */
	public void setSelectYear(LinkedHashMap<String, String> selectYear) {
		this.selectYear = selectYear;
	}

	/**
	 * コンボ月（リスト内容）
	 * @return
	 */
	public LinkedHashMap<String, String> getSelectMonth() {
		return selectMonth;
	}

	/**
	 * コンボ月（リスト内容）
	 * @param selectMonth
	 */
	public void setSelectMonth(LinkedHashMap<String, String> selectMonth) {
		this.selectMonth = selectMonth;
	}

	/**
	 * コンボ勤務種別（リスト内容）
	 * @return
	 */
	public LinkedHashMap<String, String> getSelectWorkKind() {
		return selectWorkKind;
	}

	/**
	 * コンボ勤務種別（リスト内容）
	 * @param selectWorkKind
	 */
	public void setSelectWorkKind(LinkedHashMap<String, String> selectWorkKind) {
		this.selectWorkKind = selectWorkKind;
	}

	/**
	 * アクションモード
	 * 移動、保存、Excel出力を判断する
	 * @return
	 */
	public String getActionMode() {
		return actionMode;
	}

	/**
	 * アクションモード
	 * 移動、保存、Excel出力を判断する
	 * @param actionMode
	 */
	public void setActionMode(String actionMode) {
		this.actionMode = actionMode;
	}

	/**
	 * キャッシュ対策用の時間
	 * @return
	 */
	public String getTimeString() {
		return timeString;
	}

	/**
	 * キャッシュ対策用の時間
	 * @param timeString
	 */
	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

}