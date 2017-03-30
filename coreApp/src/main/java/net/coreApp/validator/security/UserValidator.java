package net.coreApp.validator.security;

import javax.annotation.Resource;

import net.coreApp.domain.security.User;
import net.coreApp.service.security.SecurityService;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Resource(name = "userMngService")
	private SecurityService userMngService;

	public boolean supports(Class clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors){
		
	}

	public void userValidate(Object target, Errors errors,String type) {

		/** ValidationUtils를 사용 한 validation **/
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId",
				"error.userId.blank", "User ID can not be blank.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"error.password.blank", "Password can not be blank.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"error.name.blank", "name can not be blank.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "auth",
				"error.auth.blank", "auth can not be blank.");
				
		// insert시 중복 아이디 검사
		if(type.equals("C")){
			/** buisness logic을 이용한 user define validation **/
			User tmpUser = User.class.cast(target);
			String id = tmpUser.getUserId();
			// id가 존재하는지 확인
			try {
				User retUsr = userMngService.findById(id, null);
				if (retUsr != null) {
					errors.rejectValue("userId", "error.userId.duplication",
							new String[] { id }, "아이디가 존재 합니다.");
				}
			} catch (Exception e) {
			}
		}
		
	}
}
