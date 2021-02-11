package com.toyspb.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴!!
// ORM -> JAVA(다른 언어) Object -> 테이블로 매핑해주는 기
@Entity // User 클래스가 MySQL에 테이블이 생성이 된다.
// @DynamicInsert // insert 시에 null인 필드를 제외시켜준다.
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; // 시퀀스, auto_increment

    @Column(nullable = false, length = 30, unique = true)
    private String username; // 아이디

    @Column(nullable = false, length = 100) // 패스워드를 해쉬(비밀번호 암호화)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    // @ColumnDefault("'user'")
    // Enum을 사용하면 도메인을 사용할 수 있다(ex. 성별이면 -> 남, 여)
    // private String role; // Enum을 쓰는게 좋다. // ADMIN, USER

    // DB는 RoleType이라는게 없다.
    @Enumerated(EnumType.STRING)
    private RoleType role;


    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;

}
