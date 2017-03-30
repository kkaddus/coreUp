package net.coreApp.web.security;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import net.coreApp.domain.security.User;
import net.coreApp.service.security.SecurityService;
import net.coreApp.validator.security.UserValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/users")
public class UserController {
	private static final Logger log = LoggerFactory
			.getLogger(UserController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	UserValidator validator;

	@Resource(name = "userMngService")
	private SecurityService userMngService;

	@RequestMapping("/form")
	public String createForm(Model model) {
		
		model.addAttribute("user", new User());
		return "users/form";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@ModelAttribute("user") User user,
			BindingResult bindingResult, HttpSession session,
			HttpServletRequest request, SessionStatus status) throws Exception {

		// user validation 처리
		validator.userValidate(user, bindingResult, "C");
		if (bindingResult.hasErrors()) {
			return "users/form";
		}

		userMngService.create(user, request);
		
		userMngService.authCreate(user, request);
		return "redirect:/";
	}

	@RequestMapping("{userId}/form")
	public String updateForm(@PathVariable String userId, Model model,
			HttpSession session, HttpServletRequest request) throws Exception {

		Object temp = session.getAttribute("currentUserId");
		if (temp == null) {
			return "redirect:/users/login/form";
		}

		if (userId == null) {
			throw new IllegalArgumentException("사용자 아이디가 필요합니다.");
		}

		User user = userMngService.findById(userId, request);
		model.addAttribute("user", user);
		return "users/form";
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public String update(@Valid User user, BindingResult bindingResult,
			HttpSession session, HttpServletRequest request) throws Exception {

		Object temp = session.getAttribute("currentUserId");
		if (temp == null) {
			return "redirect:/users/login/form";
		}

		// user validation 처리
		validator.userValidate(user, bindingResult, "U");
		if (bindingResult.hasErrors()) {
			return "users/form";
		}

		userMngService.update(user, request);
		userMngService.authUpdate(user, request);
		return "redirect:/";
	}

	@RequestMapping("/login/form")
	public String loginForm(HttpServletRequest request) throws Exception {

		/** message binding test **/
		/*
		 * Locale locale = LocaleContextHolder.getLocale(); String message =
		 * messageSource.getMessage("user.login.fail", new String[] { "사용자", ""
		 * }, "패스워드 또는 비밀번호가 일치 하지 않습니다.", Locale.KOREA);
		 */

		return "users/login";
	}

}