package com.toyspb.blog.repository;

import com.toyspb.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// DAO
// 자동으로 bean 등록이 된다.
// @Repository // 생략 가능하다.
// JpaRepository : User 테이블 관리이고 User 테이블 pk는 integer 이다.
public interface UserRepository extends JpaRepository<User, Integer> {


}


// JPA Naming 전략
// SELECT * FROM user WHERE username = ? AND password = ?;
// User findByUsernameAndPassword(String username,String password);

// @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
// User login(String Username, String password);
