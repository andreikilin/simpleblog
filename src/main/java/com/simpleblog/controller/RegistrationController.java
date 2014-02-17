package com.simpleblog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simpleblog.entity.Member;
import com.simpleblog.form.RegistrationForm;
import com.simpleblog.validator.RegistrationFormValidator;
import com.simpleblog.service.MemberService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	public RegistrationFormValidator regValidator;
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String signup(ModelMap model) {
		RegistrationForm regForm = new RegistrationForm();
		model.put("regForm", regForm);
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("regForm") RegistrationForm regForm, BindingResult result, ModelMap model) {
		regValidator.validate(regForm, result);
		if (result.hasErrors()) {
			return "registration";
		}else {
			Member member = regForm.saveMember();
			memberService.saveMember(member);
			
		} 
		
		return "redirect:/success.html";
	}
}
