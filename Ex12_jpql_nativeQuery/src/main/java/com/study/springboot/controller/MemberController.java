package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {

    private final MemberRepository memberRepository;
	@Autowired
	MemberService mService;

    MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@GetMapping("/selectByNameLike1")
	public String selectByNameLike1(@RequestParam("name") String search,
								   Model model)
	{
		System.out.println(search);
		String name = search + "%";

		System.out.println(name);
		List<Member> result = mService.selectMember1(name);
		System.out.println(result.size());
		model.addAttribute("members", result);
		return "selectNameList";
	}
	
	
	@GetMapping("/selectByNameLike2")
	public String selectByNameLike2(@RequestParam("name") String search,
								   Model model)
	{
		System.out.println(search);
		String name = search + "%";

		System.out.println(name);
		Sort sort = Sort.by(Sort.Order.asc("id"));
		List<Member> result = mService.selectMember2(name, sort);
		System.out.println(result.size());
		model.addAttribute("members", result);
		return "selectNameList";
	}
	
	@GetMapping("/selectByNameLike3")
	public String selectByNameLike3(@RequestParam("name") String search,
								   @RequestParam("page") int page,
								   Model model)
	{
		System.out.println(search);
		String name = search + "%";

		System.out.println(name);
		Sort sort = Sort.by(Sort.Order.desc("id"));
		Pageable pageable = PageRequest.of(page-1, 10, sort);
		Page<Member> result = mService.selectMember3(name, pageable);
		System.out.println(result);
		
		List<Member> members = result.getContent();
		System.out.println(members);
		long totalElements = result.getTotalElements();
		int totalPages = result.getTotalPages();
		int size = result.getSize();
		int pageNumber = result.getNumber();
		
		model.addAttribute("members", members);
		model.addAttribute("totalElements", result.getTotalElements());
		model.addAttribute("totalPages", result.getTotalPages());
		model.addAttribute("size", result.getSize());
		model.addAttribute("pageNumber", result.getNumber()+1);
		
		return "selectNamePage";
	}
	
	@GetMapping("/selectByNameLike4")
	public String selectByNameLike4(@RequestParam("name") String search,
								   Model model)
	{
		System.out.println(search);
		String name = search + "%";

		System.out.println(name);
		List<Member> result = mService.selectMember4(name);
		System.out.println(result.size());
		model.addAttribute("members", result);
		return "selectNamePage";
	}
	
}