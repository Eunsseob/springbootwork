package com.study.springboot.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="MEMBERJPA03")
@Builder
public class Member {
	@Id
	@SequenceGenerator(
		name = "s01",
		sequenceName="JpaMember2_SEQ",
		allocationSize=1
	)
	@GeneratedValue(generator="s01")
	private Long id;
	private String name;
	private String email;
	
	public Member(String email, String name) {
		this.name = name;
		this.email = email;
	}	
}