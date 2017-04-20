package freewill.database;

import freewill.database.dto.RosterDto;


//import freewill.database.SampleDB;

public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testSelect();

		testUpdate();

	}

	private static void testUpdate() {
		//RosterDataAccess da = new RosterDataAccess();
		RosterDto dto = new RosterDto();
		dto.setStartTime("09:00");
		dto.setEndTime("18:00");
		dto.setRemarks("DTOテスト2");
		dto.setBreakTime("10:00");
		dto.setUserId("fw001");
		dto.setWorkDateKey("2017/01/02");
		//da.update(dto);
	}

	private static void testSelect() {
		RosterDataAccess da = new RosterDataAccess();
		RosterDto[] result = da.getData("201704");
		if(result == null) {
				System.out.println("Null");
				return;
		}

		for (RosterDto row : result) {
			 System.out.println(row.getWorkDateKey());
		}
	}

}
