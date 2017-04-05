package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
public class TestMain {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("hoge");
		//InputStream in = Resources.getResourceAsStream("/ClassTest/mybatis-config.xml");
		URL resource  = TestMain.class.getClassLoader().getResource("res/mybatis-config.xml");
		System.out.println(resource);
		InputStream in = resource.openConnection().getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		StringBuilder sb = new StringBuilder();

		String line;

		while ((line = br.readLine()) != null) {
		    sb.append(line);
		}

		System.out.println(sb.toString());

		br.close();

	}

}
