package com.simpleblog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String handleRoot() {
		return "redirect:/index.html";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView handleIndex(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public ModelAndView handleAbout(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("about");
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.GET)
	public ModelAndView handleContacts(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("contacts");
	}
	
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public ModelAndView handleSuccess(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("success");
	}
	
	@RequestMapping(value="/sec/moderation", method=RequestMethod.GET)  
    public ModelAndView moderatorPage() {  
        return new ModelAndView("moderation");  
    }  
      
    @RequestMapping(value="/admin/admin-page", method=RequestMethod.GET)  
    public ModelAndView firstAdminPage() {  
        return new ModelAndView("admin-page");  
    }
	
}
