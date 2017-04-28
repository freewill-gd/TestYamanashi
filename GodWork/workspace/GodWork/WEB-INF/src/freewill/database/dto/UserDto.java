package freewill.database.dto;

/**
 * ユーザDTO
 * @author user
 *
 */
public class UserDto {
	
	/**
	 * ユーザID
	 */
	private String userId;
	
	/**
	 * ユーザ名
	 */
	private String userName;
	
	/**
	 * パスワード
	 */
	private String password;
	
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
	 * ユーザ名
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * ユーザ名
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * パスワード
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * パスワード
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
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
