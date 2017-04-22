package freewill.database.dto;

/**
 * ユーザDTO
 * @author user
 *
 */
public class UserDto {
	
	private String userId; /* ユーザID */
	private String userName; /* ユーザ名 */
	private String password; /* パスワード */
	private String insertDate; /* 追加日時 */
	private String insertUserId; /* 追加ユーザID */
	private String updateDate; /* 更新日時 */
	private String updateUserId; /* 更新ユーザID */
	private String enableFlg; /* 有効フラグ｜0:無効,1:有効 */

	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getInsertUserId() {
		return insertUserId;
	}
	public void setInsertUserId(String insertUserId) {
		this.insertUserId = insertUserId;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getEnableFlg() {
		return enableFlg;
	}
	public void setEnableFlg(String enableFlg) {
		this.enableFlg = enableFlg;
	}
	
}
