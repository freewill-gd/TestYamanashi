package freewill.database;

import freewill.database.dataaccess.UserDataAccess;
import freewill.database.dto.RosterDto;
import freewill.database.dto.UserDto;


//import freewill.database.SampleDB;

public class TestDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		testSelect();

		// testUpdate();

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
		UserDataAccess da = new UserDataAccess();
		UserDto[] result = da.getData("fw001");
		if(result == null) {
				System.out.println("Null");
				return;
		}

		for (UserDto row : result) {
			 System.out.println(row.getUserName());
		}
	}

}
