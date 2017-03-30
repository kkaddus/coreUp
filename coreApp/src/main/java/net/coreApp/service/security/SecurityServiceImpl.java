/**
 * DNI Korea 물류관리 시스템 구축 사업
 * Copyright (c) 2017 S4C 기업 서비스 연구소 All rights reserved.
 *
 * ---------------------------------------------------------------------------
 * 수정일자         수정자       수정내용
 * ---------------------------------------------------------------------------
 * 2016. 12. 16.    임준혁       최초생성
 * ---------------------------------------------------------------------------
 */
package net.coreApp.service.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.coreApp.dao.security.MyBatisSecuriyDao;
import net.coreApp.domain.security.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <pre>
 * 기업관리 서비스 구현 클래스
 *
 * @author 임준혁
 * @since 2016. 12. 16.
 * @version 1.0
 * </pre>
 */
@Service("userMngService")
public class SecurityServiceImpl implements SecurityService{
	private static final Logger log = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Resource(name="myBatisSecurityDao")
	private MyBatisSecuriyDao userDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public User findById(String userId, HttpServletRequest request) throws Exception{
		return userDao.findById(userId);
	}
	@Override
	public void create(User user, HttpServletRequest request) throws Exception{
		String raw_pw = user.getPassword();
		String pw = passwordEncoder.encode(raw_pw);
		log.debug("raw passord: "+ raw_pw );
		log.debug("incrypted passord: "+ pw );
		user.setPassword(pw);
		userDao.create(user);
	}
	
	@Override
	public void update(User user, HttpServletRequest request) throws Exception{
		String raw_pw = user.getPassword();
		String pw = passwordEncoder.encode(raw_pw);
		log.debug("raw passord: "+ raw_pw );
		log.debug("incrypted passord: "+ pw );
		user.setPassword(pw);
		userDao.update(user);
	}
	
	@Override
	public void authCreate(User user, HttpServletRequest request) throws Exception{
		String raw_pw = user.getPassword();
		String pw = passwordEncoder.encode(raw_pw);
		log.debug("raw passord: "+ raw_pw );
		log.debug("incrypted passord: "+ pw );
		user.setPassword(pw);
		userDao.authCreate(user);
	}
	
	@Override
	public void authUpdate(User user, HttpServletRequest request) throws Exception{
		String raw_pw = user.getPassword();
		String pw = passwordEncoder.encode(raw_pw);
		log.debug("raw passord: "+ raw_pw );
		log.debug("incrypted passord: "+ pw );
		user.setPassword(pw);
		userDao.authUpdate(user);
	}
	
}