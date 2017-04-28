package freewill.database.dataaccess;
import java.util.HashMap;
import java.util.List;

import freewill.database.DataAccess;
import freewill.database.dto.RosterDto;

/**
 * 勤務表データアクセス
 * @author Tomoyuki Yamanashi
 *
 */
public class RosterDataAccess {
	
	/**
	 * 一月分の勤務表データ取得
	 * @param start
	 * @param userId
	 * @return
	 */
	public RosterDto[] getData(String start, String userId) {
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		int  end = Integer.parseInt(start);
		end++;
		param.put("end", String.valueOf(end));
		param.put("userId", userId);
		List<Object> result = data.selectList("test.selectT_roster", param);
		if(result == null) return null;	
		return result.toArray(new RosterDto[0]);
	}

	/**
	 * 一月分の勤務表データの合計取得
	 * @param start
	 * @param userId
	 * @return
	 */
	public RosterDto getDataSum(String start, String userId) {
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		int  end = Integer.parseInt(start);
		end++;
		param.put("end", String.valueOf(end));
		param.put("userId", userId);
		List<Object> result = data.selectList("test.selectT_rosterSum", param);
		if(result == null) return null;	
		return (RosterDto)result.get(0);
	}
	
	/**
	 * 一月分の勤務表更新
	 * @param dto
	 */
	public void updates(RosterDto[] dto) {
		DataAccess data = new DataAccess();
		data.updates("test.updateT_roster", dto);
	}
	
	/**
	 * 一月分の勤務表をカウント
	 * @param start
	 * @param userId
	 * @return
	 */
	public int getCount(String start, String userId){
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		int  end = Integer.parseInt(start);
		end++;
		param.put("end", String.valueOf(end));
		param.put("userId", userId);
		int result = data.selectOne("test.selectT_rosterCount", param);
		return result;
	}
	
	/**
	 * 一月分の勤務表を作成
	 * @param start
	 * @param userId
	 */
	public void createDate(String start, String userId){
		DataAccess data = new DataAccess();
		HashMap<String, Object> param = new HashMap<String, Object>();
		int yyyy = Integer.valueOf(start.substring(0, 4));
		int mm = Integer.valueOf(start.substring(4, 6));
		param.put("userId", userId);
		param.put("yyyy", yyyy);
		param.put("mm", mm);
		
		data.proc("test.createT_roster", param);
	}

	/**
	 * 勤務表データがない場合一月分の勤務表データを作成
	 * @param start
	 * @param userId
	 */
	public void checkData(String start, String userId){
		int count = getCount(start, userId);
		if(count > 0) return;
		createDate(start, userId);
	}
	
}
