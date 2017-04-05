package freewill;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class TestC {
	private int hoge;

	public int getHoge() {
		return hoge * 10;
	}

	public void setHoge(int hoge) {
		this.hoge = hoge;
	}



	public String getText() {

		InputStream in  = null;
		SqlSession session = null;
		List<Map<String, Object>> result = null;
        try {
        	//in = TestC.class.getResourceAsStream("/mybatis-config.xml");
        	URL resource  = TestC.class.getClassLoader().getResource("mybatis-config.xml");
        	in = resource.openConnection().getInputStream();
        	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        	session = factory.openSession();
        	result = session.selectList("test.selectTest");
        }
        catch(Exception e) {
        	// 例外処理を書くこと
        	System.out.println(e.getMessage());
        }
        finally  {
        	if (in != null){
        		try {
        			in.close();
        		}
        		catch(Exception e) {
        			// 例外処理を書くこと
        		}
        	}
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
