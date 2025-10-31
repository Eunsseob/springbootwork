package com.study.springboot.domain;

import java.time.LocalDate;


@Entity(name="Boardam")
public class Board {
	@Id
	@SequenceGenerator(
		name = "b01",
		sequenceName="Boardam_SEQ",
		allocationSize=1
	)
	@GeneratedValue(generator="b01")
	private Long bno;
	private String title;
	private String content;
	
	public Board(String email, String name) {
		this.name = name;
		this.email = email;
	}	
}