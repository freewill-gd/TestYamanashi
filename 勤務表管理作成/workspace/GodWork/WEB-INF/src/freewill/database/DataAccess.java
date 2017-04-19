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

	/**
	 *
	 * @return
	 */
	public SqlSession getSqlSession() {
    	SqlSessionFactory factory = getSqlSessionFactory();
    	return factory.openSession();
	}

	/**
	 *
	 * @param name
	 * @param param
	 * @return
	 */
	public List<Object> selectList(String name, Object param) {
		SqlSession session;
		session = getSqlSession();
		List<Object> result = null;
		try {
			result = session.selectList(name, param);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally  {
			if (session != null) session.close();
		}
		return result;
	}

	public List<Map<String, Object>> selectMapList(String name, Object param) {
		SqlSession session;
		session = getSqlSession();
		List<Map<String, Object>> result = null;
		try {
			result = session.selectList(name, param);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally  {
			if (session != null) session.close();
		}
		return result;
	}

	public void update(String name, Object param) {
		SqlSession session;
		session = getSqlSession();
		session.update(name , param);
		session.commit();
	}

	public void updates(String name, Object[] params) {
		SqlSession session;
		session = getSqlSession();
		for(Object param : params) {
			session.update(name , param);
		}
		session.commit();
	}

}
