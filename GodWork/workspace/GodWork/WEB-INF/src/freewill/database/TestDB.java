package freewill.database;

import freewill.database.dataaccess.RosterDataAccess;
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
		//testCreate();
		//testSelect();
		testSelectSum();
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
	
	private static void testSelectSum() {
		RosterDataAccess da = new RosterDataAccess();
		
		RosterDto result = da.getDataSum("201704", "fw001");
		if(result == null) {
				System.out.println("Null");
				return;
		}

		System.out.println(result.getOverTime());
	}
	
	
	private static void testSelect() {
		RosterDataAccess da = new RosterDataAccess();
		
		RosterDto[] result = da.getData("201704", "fw001");
		if(result == null) {
				System.out.println("Null");
				return;
		}

		for (RosterDto row : result) {
			 System.out.println(row.getWorkKindText());
		}
	}
	
	private static void testSelect1() {
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
	
	private static void testSelect2() {
		RosterDataAccess da = new RosterDataAccess();
		System.out.println(da.getCount("202004", "fw001"));
	}
	
	private static void testCreate() {
		RosterDataAccess da = new RosterDataAccess();
		da.checkData("201004", "hoge3");
		//System.out.println(da.getCount("202004", "fw001"));
	}

}
