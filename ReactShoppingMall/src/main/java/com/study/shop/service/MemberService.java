package com.study.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.shop.domain.Member;
import com.study.shop.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	public boolean emailCheck(String email) {
		return memberRepository.existsById(email);
	}

	public Member AddMember(Member member) {
		// TODO Auto-generated method stub
		System.out.println("들어옴");
		return memberRepository.save(member);
	}

	public Member login(Member member) {
		System.out.println("멤버 로그인");
		
		return memberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
	}
}