package net.coreApp.web.application.admin;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.coreApp.service.common.CommonService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value="/test")
	public String errorView(HttpServletRequest request, Model model) throws Exception {
		
		return "admin/test";
	}
	
	@RequestMapping(value="/ajaxTest", method={RequestMethod.POST})
	@ResponseBody
	public String ajaxTest(@RequestParam(value="title") String title, @RequestParam(value="content") String content){
		return "{\"result\" : \"OK\"}";
	}

}
