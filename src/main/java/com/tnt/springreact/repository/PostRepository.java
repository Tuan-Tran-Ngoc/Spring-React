package com.tnt.springreact.repository;

import com.tnt.springreact.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
