package com.javawebstudy.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Jiahao Wang @Description
 * @create 2022-05-19 00:14
 */
public class Client {
	public static void main(String[] args) throws IOException {

		// 加载 mybatis 核心配置文件，获取 SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		// 获取 SqlSession 对象来执行 sql
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 执行 sql
		List<User> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);

		sqlSession.close();
	}
}
