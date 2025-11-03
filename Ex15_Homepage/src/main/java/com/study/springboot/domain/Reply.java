package com.study.springboot.domain;

import java.time.LocalDate;
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
import lombok.NoArgsConstructor;

//Lombok: getter, setter, toString, equals, hashCode 메서드를 자동으로 생성
@Data
//JPA: 이 클래스가 데이터베이스 테이블과 매핑되는 엔티티임을 선언
//기본적으로 클래스명(Member)과 동일한 이름의 테이블(member)과 매핑됨
@Entity
//JPA: 엔티티의 변화를 감지하는 리스너를 등록
//AuditingEntityListener: 생성일시(@CreatedDate), 수정일시(@LastModifiedDate) 자동 설정
@EntityListeners(AuditingEntityListener.class)
public class Reply {
	@Id
	@SequenceGenerator(
			name="re",
			sequenceName="Reply_SEQ",
			allocationSize=1
			)
	@GeneratedValue(generator = "re")
	private Long rno;	
	
	@Column(nullable=false)
	private String content;
	
	private String writer;

	@Column(name="ref_bno", nullable=false)
	private Long refBno;
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
