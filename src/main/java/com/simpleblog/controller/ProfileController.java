package com.simpleblog.controller;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.simpleblog.form.ProfileForm;
import com.simpleblog.validator.ProfileFormValidator;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	ProfileFormValidator profileValidator;
	
	@RequestMapping(method=RequestMethod.GET)  
    public String profilePage(ModelMap model) {  
		model.put("title", "Edit profile");
		
		List<String> dayList = new ArrayList<String>();
		dayList.add("--");
		for(Integer i = 1; i<= 31; i++) {
			dayList.add(i.toString());
		}
		model.put("dayList", dayList);
		
		String[] months = new DateFormatSymbols().getMonths();
		List<String> monthList = new ArrayList<String>(13);
		monthList.add("--");
		for(int i = 0; i < months.length; i++) {
			monthList.add(months[i]);
		}
		model.put("monthList", monthList);
		
		List<String> yearList = new ArrayList<String>();
		yearList.add("--");
		for(Integer i = 1930 ; i<= Calendar.getInstance().get(Calendar.YEAR); i++ ) {
			yearList.add(i.toString());
		}
		model.put("yearList", yearList);
		
		ProfileForm profileForm = new ProfileForm();
		model.put("profileForm", profileForm);
		
		return "profile-edit";  
    }
	
	@RequestMapping(method=RequestMethod.POST)  
    public String processEditProfile(@Valid @ModelAttribute("profileForm") ProfileForm profileForm, 
    		BindingResult result, ModelMap model) {  
		
		profileValidator.validate(profileForm, result);
		if (result.hasErrors()) {
			return "profile-edit";
		}
		//return "redirect:/success.html";
		return "profile-edit";
    }
}
