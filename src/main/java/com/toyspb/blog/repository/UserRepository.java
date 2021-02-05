package com.toyspb.blog.repository;

import com.toyspb.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
public interface UserRepository extends JpaRepository<User, Integer> {
}
