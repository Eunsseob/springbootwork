package com.study.springboot.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	@Autowired
	MemberService mService;
	
	@Autowired
	PasswordEncoder pEncode;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("/")
    public String home() {
        return "index";
    }
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
    
	// a 태그면 Get으로 받아야됨.
	// 멤버 파일 밑에있으니 정확한 경로를 입력해주어야함.
    @GetMapping("/enrollForm")
    public String enrollForm() {
        return "member/enrollForm";
    }
    
    @GetMapping("/idCheck")
    public @ResponseBody boolean idCheck(@RequestParam("id") String id){
    	return mService.idCheck(id);
    }
    
    @PostMapping("/memberInsert")
	public String memberInsert(Member member) {
		// String enPwd = pEncoder.encode(member.getPassword());
		member.setPassword(pEncode.encode(member.getPassword()));
		mService.insert(member);
		return "redirect:/";
	}
    
    @PostMapping("/login")
	public String login(Member member, Model model) {
		Member loginUser = mService.login(member); // loginUser != null -> id 있다
		
		if(loginUser != null && pEncode.matches(member.getPassword(), loginUser.getPassword())) {
			model.addAttribute("loginUser", loginUser);  // session scope로 바꾸려면 상단에 @SessionAttributes 넣기
		}
		
		String boardDetailUrl = (String)session.getAttribute("boardDetailUrl");
		if(boardDetailUrl == null) {
			boardDetailUrl = "/";
		}
		return "redirect:" + boardDetailUrl;
	}
	/*
	 * @SessionAttributes + model을 통해 로그인 정보를 관리하는 경우
	    SessionStatus객체를 통해 사용완료 처리를 해야됨.
	    - session객체를 폐기하지 않고 재사용
	 */
    @GetMapping("/logout")
	public String logout(SessionStatus status) {
		if(!status.isComplete())
			status.setComplete();
		return "redirect:/";
	}
}
