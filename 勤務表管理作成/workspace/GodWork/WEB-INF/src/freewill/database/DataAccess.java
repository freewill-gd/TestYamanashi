package freewill.database;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author yamanashi
 *
 */
public class DataAccess {

	/**
	 *
	 * @return SqlSessionFactory
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		InputStream in = null;
		SqlSessionFactory factory = null;
		try {
			URL resource = DataAccess.class.getClassLoader().getResource("mybatis-config.xml");
			System.out.println(resource);
			in = resource.openConnection().getInputStream();
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
		return factory;
}
	public String getText() {

		List<Map<String, Object>> result = null;
		SqlSession session = null;
        try {
        	SqlSessionFactory factory = getSqlSessionFactory();
        	session = factory.openSession();
        	result = session.selectList("test.selectTest");
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
