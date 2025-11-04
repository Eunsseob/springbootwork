package com.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Reply;
import com.study.springboot.service.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

	public java.util.List<com.study.springboot.service.Reply> findAllByRefBnoOrderByRnoDesc(Long bno);
}
