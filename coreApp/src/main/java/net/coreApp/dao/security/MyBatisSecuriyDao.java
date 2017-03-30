package net.coreApp.dao.security;

import net.coreApp.dao.DBConnector;
import net.coreApp.domain.security.User;

import org.springframework.stereotype.Repository;

@Repository("myBatisSecurityDao")
public class MyBatisSecuriyDao extends DBConnector{
	
	//sucuritySqlSession 을 이용하여 질의 : security 관련(사용자 관리 / 권한 관리) db connection
		
	public User findById(String userId)throws Exception  {
		return sucuritySqlSession.selectOne("UserMapper.findById", userId);
	}

	
	public void create(User user)throws Exception  {
		sucuritySqlSession.insert("UserMapper.create", user);
	}

	
	public void update(User user) throws Exception {
		sucuritySqlSession.insert("UserMapper.update", user);
	}
	
	public void authCreate(User user)throws Exception  {
		sucuritySqlSession.insert("UserMapper.authCreate", user);
	}

	
	public void authUpdate(User user) throws Exception {
		sucuritySqlSession.insert("UserMapper.authUpdate", user);
	}

}
