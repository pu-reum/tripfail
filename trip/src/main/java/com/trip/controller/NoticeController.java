package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	String dir = "notice/";
	
	@RequestMapping("")
	public String notice(Model model) {
		model.addAttribute("center", dir+"notice");
		return "index";
	}
	
}
