package freewill.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import freewill.database.DataAccess;

public class SampleDB {
	public String getText() {
		DataAccess da = new DataAccess();
	HashMap<String, Object> param = new HashMap<String, Object>();
	param.put("table", "M_WORK");
	List<Map<String, Object>> result = da.selectList("test.selectTest", param);
	StringBuilder sb = new StringBuilder();
	if (result == null) return "";
		for (Map<String, Object> row :  result) {
			sb.append(row.get("table_name"));
			sb.append(".");
			sb.append(row.get("column_name"));
			sb.append("\r\n");
		}
		return sb.toString();
	}
}
