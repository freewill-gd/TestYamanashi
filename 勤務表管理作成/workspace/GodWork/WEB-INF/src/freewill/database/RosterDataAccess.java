package freewill.database;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RosterDataAccess {

	public List<Map<String, Object>> getData(String start) {
		// 数値変換エラー対策は現時点では未実装
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		int  end = Integer.parseInt(start);
		end++;
		param.put("end", String.valueOf(end));
		List<Map<String, Object>> result = data.selectMapList("test.selectT_roster", param);
		return result;
	}
}
