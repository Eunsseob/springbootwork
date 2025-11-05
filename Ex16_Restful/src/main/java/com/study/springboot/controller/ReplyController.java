package com.study.springboot.controller;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.domain.Reply;
import com.study.springboot.service.ReplyService;

@Controller
public class ReplyController {

    @Autowired
	ReplyService rService;

	@GetMapping("/rinsert")
	public @ResponseBody java.util.List<Reply> rinsert(Reply reply) {
		Reply result = rService.rinsert(reply);
		java.util.List<Reply> reReply = rService.selectAll(reply.getRefBno());
		return reReply;
	}
}