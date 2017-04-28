package freewill.database.dto;

/**
 * 勤務表DTO
 * @author Tomoyuki Yamanashi
 *
 */
public class RosterDto {

	/**
	 * ユーザID
	 */
	private String userId;
	
	/**
	 * 日付
	 */
	private String workDate;
	
	/**
	 * 曜日
	 */
	private String weekday;
	
	/**
	 * 日付Key
	 */
	private String workDateKey;
	
	/**
	 * 休日フラグ｜0:出勤日,1:休日
	 */
	private String holidayFlg;
	
	/**
	 * 勤務種別
	 */
	private String workKind;
	
	/**
	 * 勤務種別テキスト
	 */
	private String workKindText;
	
	/**
	 * 開始時間
	 */
	private String startTime;
	
	/**
	 * 終了時間
	 */
	private String endTime;
	
	/**
	 * 休憩
	 */
	private String breakTime;
	
	/**
	 * 残業
	 */
	private String overTime;
	
	/**
	 * 深夜残業
	 */
	private String lateNightOverTime;
	
	/**
	 * 休日残業
	 */
	private String holidayOverTime;
	
	/**
	 * 休日深夜残業
	 */
	private String holidayLateNightOverTime;
	
	/**
	 * 備考
	 */
	private String remarks;
	
	/**
	 * 追加日時
	 */
	private String insertDate;
	
	/**
	 * 追加ユーザID
	 */
	private String insertUserId;
	
	/**
	 * 更新日時
	 */
	private String updateDate;
	
	/**
	 * 更新ユーザID
	 */
	private String updateUserId;
	
	/**
	 * 有効フラグ｜0:無効,1:有効
	 */
	private String enableFlg;

	/**
	 * ユーザID
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * ユーザID
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 日付
	 * @return
	 */
	public String getWorkDate() {
		return workDate;
	}
	
	/**
	 * 日付
	 * @param workDate
	 */
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	
	/**
	 * 曜日
	 * @return
	 */
	public String getWeekday() {
		return weekday;
	}
	
	/**
	 * 曜日
	 * @param weekday
	 */
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	
	/**
	 * 日付Key
	 * @return
	 */
	public String getWorkDateKey() {
		return workDateKey;
	}
	
	/**
	 * 日付Key
	 * @param workDateKey
	 */
	public void setWorkDateKey(String workDateKey) {
		this.workDateKey = workDateKey;
	}
	
	/**
	 * 休日フラグ｜0:出勤日,1:休日
	 * @return
	 */
	public String getHolidayFlg() {
		return holidayFlg;
	}
	
	/**
	 * 休日フラグ｜0:出勤日,1:休日
	 * @param holidayFlg
	 */
	public void setHolidayFlg(String holidayFlg) {
		this.holidayFlg = holidayFlg;
	}
	
	/**
	 * 勤務種別
	 * @return
	 */
	public String getWorkKind() {
		return workKind;
	}
	
	/**
	 * 勤務種別
	 * @param workKind
	 */
	public void setWorkKind(String workKind) {
		this.workKind = workKind;
	}
	
	/**
	 * 勤務種別テキスト
	 * @return
	 */
	public String getWorkKindText() {
		return workKindText;
	}
	
	/**
	 * 勤務種別テキスト
	 * @param workKindText
	 */
	public void setWorkKindText(String workKindText) {
		this.workKindText = workKindText;
	}
	
	/**
	 * 開始時間
	 * @return
	 */
	public String getStartTime() {
		return startTime;
	}
	
	/**
	 * 開始時間
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 終了時間
	 * @return
	 */
	public String getEndTime() {
		return endTime;
	}
	
	/**
	 * 終了時間
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 休憩
	 * @return
	 */
	public String getBreakTime() {
		return breakTime;
	}
	
	/**
	 * 休憩
	 * @param breakTime
	 */
	public void setBreakTime(String breakTime) {
		this.breakTime = breakTime;
	}
	
	/**
	 * 残業
	 * @return
	 */
	public String getOverTime() {
		return overTime;
	}
	
	/**
	 * 残業
	 * @param overTime
	 */
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	
	/**
	 * 深夜残業
	 * @return
	 */
	public String getLateNightOverTime() {
		return lateNightOverTime;
	}
	
	/**
	 * 深夜残業
	 * @param lateNightOverTime
	 */
	public void setLateNightOverTime(String lateNightOverTime) {
		this.lateNightOverTime = lateNightOverTime;
	}
	
	/**
	 * 休日残業
	 * @return
	 */
	public String getHolidayOverTime() {
		return holidayOverTime;
	}
	
	/**
	 * 休日残業
	 * @param holidayOverTime
	 */
	public void setHolidayOverTime(String holidayOverTime) {
		this.holidayOverTime = holidayOverTime;
	}
	
	/**
	 * 休日深夜残業
	 * @return
	 */
	public String getHolidayLateNightOverTime() {
		return holidayLateNightOverTime;
	}
	
	/**
	 * 休日深夜残業
	 * @param holidayLateNightOverTime
	 */
	public void setHolidayLateNightOverTime(String holidayLateNightOverTime) {
		this.holidayLateNightOverTime = holidayLateNightOverTime;
	}
	
	/**
	 * 備考
	 * @return
	 */
	public String getRemarks() {
		return remarks;
	}
	
	/**
	 * 備考
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	/**
	 * 追加日時
	 * @return
	 */
	public String getInsertDate() {
		return insertDate;
	}
	
	/**
	 * 追加日時
	 * @param insertDate
	 */
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	
	/**
	 * 追加ユーザID
	 * @return
	 */
	public String getInsertUserId() {
		return insertUserId;
	}
	
	/**
	 * 追加ユーザID
	 * @param insertUserId
	 */
	public void setInsertUserId(String insertUserId) {
		this.insertUserId = insertUserId;
	}
	
	/**
	 * 更新日時
	 * @return
	 */
	public String getUpdateDate() {
		return updateDate;
	}
	
	/**
	 * 更新日時
	 * @param updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	/**
	 * 更新ユーザID
	 * @return
	 */
	public String getUpdateUserId() {
		return updateUserId;
	}
	
	/**
	 * 更新ユーザID
	 * @param updateUserId
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	
	/**
	 * 有効フラグ｜0:無効,1:有効
	 * @return
	 */
	public String getEnableFlg() {
		return enableFlg;
	}
	
	/**
	 * 有効フラグ｜0:無効,1:有効
	 * @param enableFlg
	 */
	public void setEnableFlg(String enableFlg) {
		this.enableFlg = enableFlg;
	}
}
