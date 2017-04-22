package freewill.bean;

import org.apache.struts.action.ActionForm;

/**
 * ログインフォーム
 * @author Tomoyuki Yamanashi
 *
 */
public class LoginBean extends ActionForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2095343500027325049L;

	/**
	 * ユーザID
	 */
	private String userId = "";
	
	/**
	 * パスワード
	 */
	private String password = "";
	
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
