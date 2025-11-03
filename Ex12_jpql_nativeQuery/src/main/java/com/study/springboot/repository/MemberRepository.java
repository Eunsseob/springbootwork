package com.study.springboot.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	// JPQL 쿼리 : java에 있는 영속성의 쿼리문
	@Query("select m from JPAPAGING m where m.name like :name1 order by m.id desc")
	java.util.List<Member> findMembers(@Param("name1") String n); // like와 같은 이름으로 넣어야됨
	
	@Query("select m from JPAPAGING m where m.name like :n")
	java.util.List<Member> findMembers(@Param("n") String name, org.springframework.data.domain.Sort sort);

	@Query("select m from JPAPAGING m where m.name like :name")
	Page<Member> findMembers(@Param("name") String name, Pageable pageable);
	
	// 일반 sql 쿼리
	@Query(value="selct * from jpapaging where name like :name1 order by id desc",
			nativeQuery = true)
	List<Member> findMembersNative(@Param("name1") String name);
	
}