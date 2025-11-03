package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Board {
	@Id
	@SequenceGenerator(
			name="bo",
			sequenceName="Board_SEQ",
			allocationSize=1
			)
	@GeneratedValue(generator = "bo")
	private Long bno;
	
	@Column(nullable=false)
	private String title;
	@Column(nullable=false)
	private String content;
	
	private String writer;
	@Column(insertable=false, columnDefinition = "NUMBER DEFAULT 0")
	private Long count;
	
	 @CreatedDate
	 // JPA: 데이터베이스의 컬럼명을 "create_date"로 지정
	 // 필드명(createDate)과 다른 컬럼명 사용 시 명시
	 @Column(name="create_date")
	 private LocalDateTime createDate;
	 // Spring Data JPA: 엔티티가 수정될 때마다 시간을 자동으로 업데이트
	 // INSERT와 UPDATE 시점에 모두 자동으로 현재 시간 저장
	 @LastModifiedDate
	 // JPA: 데이터베이스의 컬럼명을 "update_date"로 지정
	 @Column(name="update_date")
	 private LocalDateTime updateDate;
}
