package freewill.database;

import java.io.InputStream;
import java.net.URL;
//import java.util.List;
//import java.util.Map;

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

	/**
	 *
	 * @return
	 */
	public SqlSession getSqlSession() {
    	SqlSessionFactory factory = getSqlSessionFactory();
    	return factory.openSession();
	}

}
