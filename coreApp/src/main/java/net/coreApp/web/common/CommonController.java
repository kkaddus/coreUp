package net.coreApp.web.common;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.coreApp.service.common.CommonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
@RequestMapping(value="/common")
public class CommonController {
	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	@Resource(name="commonService")		
	private CommonService commonService;
	
	@Resource(name="messageSource")
    private MessageSource messageSource;
	
	@RequestMapping(value="/error")
	public String errorView(HttpServletRequest request, Model model) throws Exception {
		EgovMap map = commonService.errPageHandler(request);
		model.addAttribute("args", map);
		return "error/error";
	}
	/** access denied error **/
	@RequestMapping(value="/accessDeniedError")
	public String accessDeniedErrorView(Model model) throws Exception {
		EgovMap map = new EgovMap();
		map.put("ERROR_CODE", "403");
		map.put("MSG_KO", messageSource.getMessage("err.msg.403",
				new String[] {}, Locale.getDefault()));
		map.put("MSG_EN", messageSource.getMessage("err.msg.403.en",
				new String[] {}, Locale.getDefault()));
		model.addAttribute("args", map);
		return "error/error";
	}

}
