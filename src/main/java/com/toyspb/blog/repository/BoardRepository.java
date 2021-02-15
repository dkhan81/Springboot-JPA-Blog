package com.toyspb.blog.repository;

import com.toyspb.blog.model.Board;
import com.toyspb.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
