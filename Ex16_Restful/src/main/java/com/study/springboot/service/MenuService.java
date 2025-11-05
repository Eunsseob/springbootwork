package com.study.springboot.service;

import java.awt.Menu;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;
import com.study.springboot.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository mRepository;

	public List<com.study.springboot.domain.Menu> menuAllList() {
		return mRepository.findAll();
	}

	public List<com.study.springboot.domain.Menu> findByType(Type type) {
		// TODO Auto-generated method stub
		return mRepository.findByType(type);
	}

	public List<com.study.springboot.domain.Menu> findByTypeAndTaste(Type type, Taste taste) {
		// TODO Auto-generated method stub
		return mRepository.findByTypeAndTaste(type, taste);
	}

}