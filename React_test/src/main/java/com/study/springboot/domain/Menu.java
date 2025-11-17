package com.study.springboot.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Menu {
	@Id
	@SequenceGenerator(
		name = "m",
		sequenceName = "Menu_SEQ",
		allocationSize=1
	)
	@GeneratedValue(generator="m")
	private Long id;
	private String restaurant;	// 음식점
	private String name;			// 메뉴이름
	private Long price;			// 가격
	
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Enumerated(EnumType.STRING)
	private Taste taste;
}