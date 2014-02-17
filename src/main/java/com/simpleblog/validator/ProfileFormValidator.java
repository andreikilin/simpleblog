package com.simpleblog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mysql.jdbc.Field;
import com.simpleblog.form.ProfileForm;

@Component("ProfileFormValidator")
public class ProfileFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ProfileForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ProfileForm profileForm = (ProfileForm) target;
		String defaultMessage = "Field is required";
		
		// First Name validation
		
		if(!profileForm.getFirstName().isEmpty()) {
			if(profileForm.getFirstName().contains(" ")) {
				errors.rejectValue("firstName", "field.witespase");
			}
			if (!errors.hasFieldErrors("firstName")) {
						if (((profileForm.getFirstName().length()) > 16) || (profileForm.getFirstName().length()) < 3) {
								errors.rejectValue("firstName", "lenght.firtsName");
						}
				}
		}
		
		// Last Name validation
		if(!profileForm.getLastName().isEmpty()) {
			if(profileForm.getLastName().contains(" ")) {
				errors.rejectValue("lastName", "field.witespase");
			}
			if (!errors.hasFieldErrors("lastName")) {
						if (((profileForm.getFirstName().length()) > 16) || (profileForm.getFirstName().length()) < 3) {
								errors.rejectValue("lastName", "lenght.lastName");
						}
				}
		}
		
		
		// City validation
		if(!profileForm.getCity().isEmpty()) {
			if(profileForm.getLastName().contains(" ")) {
				errors.rejectValue("city", "field.witespase");
			}
			if (!errors.hasFieldErrors("city")) {
						if (((profileForm.getFirstName().length()) > 16) || (profileForm.getFirstName().length()) < 3) {
								errors.rejectValue("city", "lenght.city");
						}
				}
		}
		
		
		// Birthday validation
		if(profileForm.getBirthDay() != null) {
			
		}
		
	}

}
