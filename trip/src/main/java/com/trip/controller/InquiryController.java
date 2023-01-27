package com.trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trip.dto.Inquiry;
import com.trip.service.InquiryService;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	String dir = "inquiry/";

	@Autowired
	InquiryService is;

	// 목록
	@RequestMapping("")
	public String inquiry(Model model) throws Exception {

		// 글 목록
		List<Inquiry> list = is.selectInquiryList();
		model.addAttribute("list", list);
		model.addAttribute("center", dir + "inquiry");
		return "index";
	}

	// 글 쓰기
	@GetMapping("/inquirywrite")
	public String inquirywrite(Model model, HttpSession session) throws Exception{
		String custid = (String)session.getAttribute("custid");
		model.addAttribute("center", dir + "inquirywrite");
		return "index";
	}

	// 글쓰기 완료
	@PostMapping("/inquirywriteok")
	public String inquirywriteok(Inquiry inquiry, Model model) throws Exception {
		is.insertInquiry(inquiry);
		model.addAttribute("result", inquiry);
		return "redirect:/inquiry";

	}

	// 글 상세보기
	@GetMapping("/inquiryview")
	public String inquiryview(Model model, Integer inquiryid) throws Exception {

		Inquiry inquiry = is.selectInquiry(inquiryid);
		model.addAttribute("board", inquiry);
		model.addAttribute("center", dir + "inquiryview");
		return "index";
	}

	// 글 수정
	@RequestMapping("/inquiryedit")
	public String inquiryedit(Model model, Inquiry inquiry) throws Exception {
		is.updeateInquiry(inquiry);
		model.addAttribute("result", inquiry);
		model.addAttribute("center", dir + "inquiryedit");
		return "redirect:/inquiryview";
	}

	// 글 삭제
	@RequestMapping("/inquirydelete")
	public String inquirydelete(int inquiryid) {

		return "redirect:/inquiry";
	}

}