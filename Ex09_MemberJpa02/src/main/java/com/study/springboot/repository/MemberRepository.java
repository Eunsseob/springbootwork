package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	List<Member> findByName(String name);

	List<Member> findByEmail(String email);

	List<Member> findByNameLike(String name);
	List<Member> findByNameLikeOrderByNameDesc(String name);
	List<Member> findByNameLikeOrderByNameDescEmailAsc(String name);
}