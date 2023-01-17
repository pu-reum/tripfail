package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CourseController {

	String dir = "course/";
	
	@RequestMapping("")
	public String course(Model model) {
		model.addAttribute("center", dir+"course");
		return "index";
	}
	
}
