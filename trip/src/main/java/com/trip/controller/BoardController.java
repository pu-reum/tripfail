package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	String dir = "board/";
	
	@RequestMapping("")
	public String board(Model model) {
		model.addAttribute("center", dir+"board");
		return "index";
	}
	
}
