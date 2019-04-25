package cn.wangfan.util;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * SqlSessionFactory 单例
 * 
 * @author wangfan
 *
 */
public class SsfSington {
	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		try {
			Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader, "development");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getInstance() {
		return sqlSessionFactory;
	}

}
