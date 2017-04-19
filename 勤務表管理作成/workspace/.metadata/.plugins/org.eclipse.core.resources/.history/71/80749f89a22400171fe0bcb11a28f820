package freewill.database;


//import freewill.database.SampleDB;

public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		RosterDataAccess da = new RosterDataAccess();
		RosterDto[] result = da.getData("201704");
		if(result == null) {
				System.out.println("Null");
				return;
		}

		for (RosterDto row : result) {
			 System.out.println(row.getRemarks());
		}

	}

}
