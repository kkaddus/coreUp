package net.coreApp.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

public class DBConnector {

	@Resource(name="sqlSession")
	public SqlSession sqlSession;
	
	@Resource(name="securitySqlSession")
	public SqlSession sucuritySqlSession;
	
}
