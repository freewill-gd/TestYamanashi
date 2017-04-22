package freewill.database;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * データアクセスクラス
 * @author Tomoyuki Yamanashi
 *
 */
public class DataAccess {

	/**
	 *　ファクトリ取得
	 * @return SqlSessionFactory
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		InputStream in = null;
		SqlSessionFactory factory = null;
		try {
			URL resource = DataAccess.class.getClassLoader().getResource("mybatis-config.xml");
			in = resource.openConnection().getInputStream();
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
		return factory;
	}

	/**
	 *　セッション取得
	 * @return
	 */
	public SqlSession getSqlSession() {
    	SqlSessionFactory factory = getSqlSessionFactory();
    	return factory.openSession();
	}

	/**
	 * DB取得
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

	/**
	 * DB取得
	 * @param name
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> selectMapList(String name, Object param) {
		SqlSession session;
		session = getSqlSession();
		List<Map<String, Object>> result = null;
		try {
			result = session.selectList(name, param);
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		finally  {
			if (session != null) session.close();
		}
		return result;
	}

	/**
	 * DB更新
	 * @param name
	 * @param param
	 */
	public void update(String name, Object param) {
		SqlSession session = null;
		try {
			session = getSqlSession();
			session.update(name , param);
			session.commit();
		}
		catch(Exception e) {
				if(session != null) {
					session.rollback();
				}
				System.err.println(e.getMessage());
		}
		finally  {
			if (session != null) session.close();
		}
	}

	/**
	 * DB更新複数
	 * @param name
	 * @param params
	 */
	public void updates(String name, Object[] params) {
		SqlSession session = null;
		try {
			session = getSqlSession();
			for(Object param : params) {
				session.update(name , param);
			}
			session.commit();
		}
		catch(Exception e) {
				if(session != null) {
					session.rollback();
				}
				System.err.println(e.getMessage());
		}
		finally  {
			if (session != null) session.close();
		}
	}

}
