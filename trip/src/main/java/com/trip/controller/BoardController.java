package com.trip.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trip.dto.Board;
import com.trip.dto.Category;
import com.trip.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	String dir = "board/";
	
	@Autowired
	BoardService bs;
	
	//목록
	@RequestMapping("")
	public String board(Model model, Board board) throws Exception {
		
		//글 목록
		List <Board> list = bs.selectBoardList(board);
		model.addAttribute("list", list);
		//bs.categoryEnum(board);
		model.addAttribute("center", dir+"board");
		return "index";
	}
	//글 쓰기
	@GetMapping("/boardwrite")
	public String boardwrite(Model model) {
		model.addAttribute("center", dir+"boardwrite");
		return "index";
	}
	//글쓰기 완료
	@PostMapping("/boardwriteok")
	public String boardwriteok(Board board, Model model) throws Exception {
		bs.insertBoard(board);
		model.addAttribute("result", board);
		return "redirect:/board";
		
	}
	//글 상세보기
	@GetMapping("/boardview")
	public String boardview(Model model, Integer postid) throws Exception {
		
		Board board=bs.selectBoard(postid);
		model.addAttribute("board", board);
		model.addAttribute("center", dir+"boardview");
		return "index";
	}
	//글 수정
	@RequestMapping("/boardedit")
	public String boardedit(Model model, Board board) throws Exception {
		bs.updeateBoard(board);
		model.addAttribute("result", board);
		model.addAttribute("center", dir+"boardedit");
		return "redirect:/boardview";
	}
	//글 삭제
	@RequestMapping("/boarddelete")
	public String boarddelete(int postid, HttpSession session) throws Exception {
		String custid=(String)session.getAttribute("custid");
	
		return "redirect:/board";
	}
	
	@ModelAttribute("categorys")
	public List<Category> categorys(){
		List<Category> categorys = new ArrayList<>();
		categorys.add(new Category(1, "여행지"));
		categorys.add(new Category(2, "맛집"));
		categorys.add(new Category(3, "축제"));
		categorys.add(new Category(4, "기타"));
		
		return categorys;
	}
	
}
