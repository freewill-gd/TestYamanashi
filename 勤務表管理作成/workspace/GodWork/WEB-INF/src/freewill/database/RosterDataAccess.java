package freewill.database;
import java.util.List;
import java.util.Map;

public class RosterDataAccess {

	public List<Map<String, Object>> getData() {
		DataAccess data = new DataAccess();
		//HashMap<String, Object> param = new HashMap<String, Object>();
		//param.put("table", "T_WORK_TIME");
		List<Map<String, Object>> result = data.selectMapList("test.selectT_roster", null);
		//List<Map<String, Object>> result = data.selectMapList("selectTest", param);
		return result;
	}
}
