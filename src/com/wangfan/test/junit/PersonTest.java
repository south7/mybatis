package com.wangfan.test.junit;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.wangfan.vo.Person;

public class PersonTest {
    /**
     * 加载mybatis配置文件，为了访问数据库
     * SqlSessionFactory获得connection
     * @throws IOException 获取mybatis-config.xml异常
     */
	@Test
	public void test() throws IOException{
		Reader resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsReader);
		SqlSession openSession = build.openSession();
		String statement="cn.wangfan.mapper.PersonMapper.findPersonById";
		Person person = openSession.selectOne(statement, 1);
		System.out.println(person.getName());
		openSession.close();
	}
}
