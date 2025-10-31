package com.study.springboot.domain;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

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
	
	@ManyToOne
	@JoinColumn(name="writer")
	private Member member;
}