package freewill.database.dataaccess;

import java.util.HashMap;
import java.util.List;

import freewill.database.DataAccess;
import freewill.database.dto.UserDto;

/**
 * ユーザデータアクセス
 * @author Tomoyuki Yamanashi
 *
 */
public class UserDataAccess {

	/**
	 * ユーザデータを取得
	 * @param userId
	 * @return
	 */
	public UserDto[] getData(String userId) {
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		List<Object> result = data.selectList("user.selectM_user", param);
		if (result == null) return null;
		return result.toArray(new UserDto[0]);
	}
}
