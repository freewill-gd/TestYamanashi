package freewill.database;

import java.util.List;
import java.util.Map;

//import freewill.database.SampleDB;

public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		RosterDataAccess da = new RosterDataAccess();
		List<Map<String, Object>> result = da.getData("201704");
		if(result == null) {
				System.out.println("Null");
				return;
		}

		for (Map<String, Object> row : result) {
			for(Map.Entry<String, Object> col : row.entrySet()) {
				System.out.print(col.getValue() + " ");
			}
			System.out.println(" ");
		}

	}

}
