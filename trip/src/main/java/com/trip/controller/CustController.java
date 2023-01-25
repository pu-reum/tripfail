package com.trip.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.trip.dto.Cust;
import com.trip.service.CustService;

@Controller
public class CustController {

	String dir = "cust/";
	
	@Autowired
	CustService service;
	
	@RequestMapping("/regist")
	public String regist(Model model) {
		model.addAttribute("center", dir+"regist");
		return "index";
	}
	
	@RequestMapping("/registimpl")
	public String registimpl(Model model, Cust cust, HttpSession session) {
		
		 try { 
			 	service.register(cust); 
			 	session.setAttribute("logincust", cust);
			 	model.addAttribute("center", dir+"registok");
			 }catch (Exception e) { 
				 model.addAttribute("center", dir+"registfail");
				 e.printStackTrace(); 
				 e.getStackTrace();
			 }
		
		return "index";
	}

	@RequestMapping("/useredit")
	public String useredit(Model model, String id) {
		Cust cust=new Cust();
		try {
			cust=service.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cust!=null) {
			try {
				service.nickremove(cust);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("editcust", cust);
		model.addAttribute("center", dir+"edit");
		return "index";
	}
	
	@RequestMapping("/usereditimpl")
	public String usereidtimpl(Model model, Cust cust, HttpSession session) {
		
		 try { 
			 	service.modify(cust); 
			 	session.setAttribute("logincust", cust);
			 	model.addAttribute("center", dir+"registok");
			 }catch (Exception e) { 
				 model.addAttribute("center", dir+"registfail");
				 e.printStackTrace(); 
				 e.getStackTrace();
			 }
		
		return "index";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "index";
	}
}


























