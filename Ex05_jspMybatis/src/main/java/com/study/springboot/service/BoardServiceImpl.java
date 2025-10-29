package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;


@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository boardDao;
	
	@Override
	public List<Board> list() {
		// TODO Auto-generated method stub
		return boardDao.list();
	}

	@Override
	public Board detailBoard(int boardno) {
		// TODO Auto-generated method stub
		return boardDao.detailBoard(boardno);
	}

	@Override
	public int totalRecord() {
		// TODO Auto-generated method stub
		return boardDao.totalRecord();
	}

	@Override
	public int insertBoard(Board b) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(b);
	}

	@Override
	public int deleteBoard(int boardno) {
		// TODO Auto-generated method stub
		return boardDao.deleteBoard(boardno);
	}

}
