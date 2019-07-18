package com.biz.memo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.biz.memo.service.MemberService;

@Controller
public class MemberConteroller {
	
	@Autowired
	MemberService mService;
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join(Model model) {
			model.addAttribute("BODY", "JOIN");
		
		return "home";
	}
}
