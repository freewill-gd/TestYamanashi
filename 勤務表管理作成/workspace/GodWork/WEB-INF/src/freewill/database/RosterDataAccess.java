package freewill.database;
import java.util.HashMap;
import java.util.List;

public class RosterDataAccess {

	public RosterDto[] getData(String start) {
		// 数値変換エラー対策は現時点では未実装
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		int  end = Integer.parseInt(start);
		end++;
		param.put("end", String.valueOf(end));
		List<Object> result = data.selectList("test.selectT_roster", param);
		if(result == null) return null;
		return result.toArray(new RosterDto[0]);
	}

	public void update() {
		DataAccess data = new DataAccess();
		data.update("test.updateT_roster", null);
	}
}
