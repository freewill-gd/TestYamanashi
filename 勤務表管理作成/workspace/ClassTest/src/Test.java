import java.util.Date;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
			Date d = new Date();
			long l = d.getTime();
			String s = "?time=" + String.valueOf(l);
			System.out.println(s);
	}

}
