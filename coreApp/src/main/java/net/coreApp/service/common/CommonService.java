package net.coreApp.service.common;

import javax.servlet.http.HttpServletRequest;

import egovframework.rte.psl.dataaccess.util.EgovMap;


public interface CommonService {

	
	/**에러페이지 처리 서비스*/
	public EgovMap errPageHandler(HttpServletRequest request) throws Exception;

	
}