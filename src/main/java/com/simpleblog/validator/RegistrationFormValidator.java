package com.simpleblog.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.simpleblog.form.RegistrationForm;
import com.simpleblog.service.MemberService;


@Component("RegistrationFormValidator")
public class RegistrationFormValidator implements Validator{

	@Autowired
	MemberService memberService;
	
	public boolean supports(Class<?> clazz) {
		
		return RegistrationForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		String defaultMessage = "Field is required";
		RegistrationForm regForm = (RegistrationForm) target;
		
		
		// User name validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "required.userName", defaultMessage);
		if (!errors.hasFieldErrors("userName")) {
			if (((regForm.getUserName().length()) > 16) || (regForm.getUserName().length()) < 3) {
				errors.rejectValue("userName", "lenght.userName");
			} else 
				if(memberService.findByName(regForm.getUserName()) != null) {
					errors.rejectValue("userName", "exist.userName");
				}
		}
		
		// Password validation
		if(((regForm.getPassword().length()) > 20) || (regForm.getPassword().length()) < 4) {
			errors.rejectValue("password", "lenght.password");
		} else 
			if(!(regForm.getPassword().equals(regForm.getConfirmPassword()))){
				errors.rejectValue("password", "mismatch.password");
			}
		
		// Email validation
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", defaultMessage);
		if(!errors.hasFieldErrors("email")) {
			if(!EmailValidator.getInstance().isValid( regForm.getEmail() ) ){
				errors.rejectValue("email", "mismatch.email");
			}else 
				if(memberService.findByEmail(regForm.getEmail()) != null) {
					errors.rejectValue("email", "exist.email");
				}
		}
		
	}

	
}
