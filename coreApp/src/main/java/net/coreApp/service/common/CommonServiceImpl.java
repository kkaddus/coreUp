package net.coreApp.service.common;

import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);
	
	@Resource(name="messageSource")
    private MessageSource messageSource;
	
	@Override
	public EgovMap errPageHandler(HttpServletRequest request) throws Exception {
		EgovMap map = new EgovMap();
		int errType = (int) request.getAttribute("javax.servlet.error.status_code");


		switch(errType){
			case 403:
				map.put("ERROR_CODE", errType);
				map.put("MSG_KO", messageSource.getMessage("err.msg.403",
						new String[] {}, Locale.getDefault()));
				map.put("MSG_EN", messageSource.getMessage("err.msg.403.en",
						new String[] {}, Locale.getDefault()));
				break;
			case 404 :
				map.put("ERROR_CODE", errType);
				map.put("MSG_KO", messageSource.getMessage("err.msg.404", new String[] {}, Locale.getDefault()));
				map.put("MSG_EN", messageSource.getMessage("err.msg.404.en", new String[] {}, Locale.getDefault()));
				break;
			case 405 :
				map.put("ERROR_CODE", errType);
				map.put("MSG_KO", messageSource.getMessage("err.msg.405", new String[] {}, Locale.getDefault()));
				map.put("MSG_EN", messageSource.getMessage("err.msg.405.en", new String[] {}, Locale.getDefault()));
				break;
			case 500 :
				map.put("ERROR_CODE", errType);
				map.put("MSG_KO", messageSource.getMessage("err.msg.500", new String[] {}, Locale.getDefault()));
				map.put("MSG_EN", messageSource.getMessage("err.msg.500.en", new String[] {}, Locale.getDefault()));
				break;
			default : 
				map.put("ERROR_CODE", errType);
				map.put("MSG_KO", messageSource.getMessage("err.msg", new String[] {}, Locale.getDefault()));
				map.put("MSG_EN", messageSource.getMessage("err.msg.en", new String[] {}, Locale.getDefault()));
				break;
		}
		pageErrLog(request);

		return map;
	}
	
	private void pageErrLog(HttpServletRequest request){
		log.info("STATUS_CODE > "+request.getAttribute("javax.servlet.error.status_code"));
		log.info("EXCEPTION_TYPE > "+request.getAttribute("javax.servlet.error.exception_type"));
		log.info("MESSAGE > "+request.getAttribute("javax.servlet.error.message"));
		log.info("REQUEST_URI > "+request.getAttribute("javax.servlet.error.request_uri"));
		log.info("EXCEPTION > "+request.getAttribute("javax.servlet.error.exception"));
		log.info("SERVLET_NAME > "+request.getAttribute("javax.servlet.error.servlet_name"));
	}


}
