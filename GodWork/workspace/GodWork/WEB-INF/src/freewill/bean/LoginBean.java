package freewill.bean;

/**
 * @author user
 *
 */
public class LoginBean {
	
	/**
	 * ユーザID
	 */
	private String userId;
	
	/**
	 * パスワード
	 */
	private String password;
	
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

}
