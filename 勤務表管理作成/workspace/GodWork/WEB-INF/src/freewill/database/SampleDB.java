package freewill.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import freewill.database.DataAccess;

public class SampleDB {
	public String getText() {
		DataAccess da = new DataAccess();
		List<Map<String, Object>> result = null;
		SqlSession session = null;
        try {
        	session = da.getSqlSession();
        	HashMap<String, Object> param = new HashMap<String, Object>();
        	param.put("table", "T_WORK_TIME");
        	result = session.selectList("test.selectTest", param);
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        finally  {
        	if (session != null) session.close();
        }

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
