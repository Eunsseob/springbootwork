package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.domain.Reply;
import com.study.springboot.service.BoardService;

@Controller
@SessionAttributes("loginUser")
public class BoardController {

	@Autowired
	BoardService bService;
	
	@GetMapping("list")
	public String list(Model model) {
		List<Board> list = bService.list();
		model.addAttribute("list", list);
		return "board/list";
	}
	@PostMapping("/insert")
	public String insert(Board board) {
		bService.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm(@SessionAttribute(value="loginUser", required=false) Member loginUser , Model model) {
		model.addAttribute("loginUser", loginUser);
		return "board/insertForm";
	}
	
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam("bno") Long bno, Model model) {
//		Board board = bService.selectDetail(bno).get();
//		List<Reply> ReplySerivce = rService.selectAll(bno);
		model.addAttribute("board", Board);
		model.addAttribute("reply", replyList);
		return "board/detailForm";
	}
	
}