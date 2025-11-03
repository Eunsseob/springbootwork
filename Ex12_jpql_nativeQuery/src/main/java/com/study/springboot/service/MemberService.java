package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository mRepository;


	public List<Member> selectMember1(String name) {
		// TODO Auto-generated method stub
		return mRepository.findMembers(name);
	}

	// 오버로딩 만들어준 꼴
	
	public List<Member> selectMember2(String name, Sort sort) {
		// TODO Auto-generated method stub
		return mRepository.findMembers(name, sort);
	}

	public Page<Member> selectMember3(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return mRepository.findMembers(name, pageable);
	}

	public List<Member> selectMember4(String name) {
		// TODO Auto-generated method stub
		return mRepository.findMembers(name);
	}
}