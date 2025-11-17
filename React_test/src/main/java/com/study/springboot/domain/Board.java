package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Board {
	@Id
	@SequenceGenerator (
			name="bo",
			sequenceName="Board_SEQ",
			allocationSize=1
			)
	@GeneratedValue(generator="bo")
	private Long bno;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String content;
	
	@Column(nullable=false)
	private String writer;
	
	@Column(insertable=false, columnDefinition="NUMBER DEFAULT 0")
	private Long count;
	
	@CreatedDate
	@Column(name="create_date")
	private LocalDateTime createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;
}