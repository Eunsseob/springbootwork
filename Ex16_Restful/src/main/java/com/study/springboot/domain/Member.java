package com.study.springboot.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

// Lombok: getter, setter, toString, equals, hashCode 메서드를 자동으로 생성
@Data

// Lombok: 파라미터가 없는 기본 생성자를 자동으로 생성
@NoArgsConstructor

// JPA: 이 클래스가 데이터베이스 테이블과 매핑되는 엔티티임을 선언
// 기본적으로 클래스명(Member)과 동일한 이름의 테이블(member)과 매핑됨
@Entity

// JPA: 엔티티의 변화를 감지하는 리스너를 등록
// AuditingEntityListener: 생성일시(@CreatedDate), 수정일시(@LastModifiedDate) 자동 설정
@EntityListeners(AuditingEntityListener.class)
public class Member {
    
    // JPA: 이 필드가 Primary Key(기본키)임을 지정
    // 테이블의 id 컬럼과 매핑되며, 각 레코드를 고유하게 식별
    @Id
    private String id;

    // Lombok/Validation: 이 필드가 null이 아니어야 함을 나타냄
    // 주의: 이것만으로는 DB 제약조건이 생성되지 않음
    @NonNull
    
    // JPA: 컬럼의 제약조건을 설정
    // nullable=false: 데이터베이스에서 이 컬럼을 NOT NULL로 생성
    @Column(nullable=false)
    private String password;

    // JPA: 이름 필드는 필수값(NOT NULL)
    @Column(nullable=false)
    private String name;
    
    // 컬럼 어노테이션이 없으면 필드명과 동일한 컬럼명으로 자동 매핑
    // 기본적으로 nullable=true (NULL 허용)
    private String email;
    
    private LocalDate birthday;
    
    private String gender;
    
    private String phone;
    
    private String address;

    // Spring Data JPA: 엔티티가 생성되어 저장될 때 시간을 자동으로 저장
    // @EntityListeners(AuditingEntityListener.class)와 함께 사용
    // Application 클래스에 @EnableJpaAuditing 필요
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
