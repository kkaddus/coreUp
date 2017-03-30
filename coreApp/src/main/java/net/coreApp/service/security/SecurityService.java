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

import javax.servlet.http.HttpServletRequest;

import net.coreApp.domain.security.User;

import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 * 기업관리 서비스 정의 인터페이스
 *
 * @author 임준혁
 * @since 2016. 12. 16.
 * @version 1.0
 * </pre>
 */
public interface SecurityService {
	
	public User findById(String userId, HttpServletRequest request) throws Exception;

	@Transactional public void create(User user, HttpServletRequest request) throws Exception;

	@Transactional public void update(User user, HttpServletRequest request) throws Exception;
	
	@Transactional public void authCreate(User user, HttpServletRequest request) throws Exception;

	@Transactional public void authUpdate(User user, HttpServletRequest request) throws Exception;
	
	
}
