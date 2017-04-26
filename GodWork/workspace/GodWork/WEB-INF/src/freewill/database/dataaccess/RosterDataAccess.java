package freewill.database.dataaccess;
import java.util.HashMap;
import java.util.List;

import freewill.database.DataAccess;
import freewill.database.dto.RosterDto;

/**
 * 勤務表データアクセス
 * @author Tomoyuki Yamanashi
 *
 */
public class RosterDataAccess {

	public RosterDto[] getData(String start, String userId) {
		// 数値変換エラー対策は現時点では未実装
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		int  end = Integer.parseInt(start);
		end++;
		param.put("end", String.valueOf(end));
		param.put("userId", userId);
		List<Object> result = data.selectList("test.selectT_roster", param);
		if(result == null) return null;
		return result.toArray(new RosterDto[0]);
	}

	public void updates(RosterDto[] dto) {
		DataAccess data = new DataAccess();
		data.updates("test.updateT_roster", dto);
	}
	
	public int getCount(String start, String userId){
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		int  end = Integer.parseInt(start);
		end++;
		param.put("end", String.valueOf(end));
		param.put("userId", userId);
		int result = data.selectOne("test.selectT_rosterCount", param);
		return result;
	}
}
