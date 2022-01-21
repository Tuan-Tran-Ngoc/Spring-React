package com.tnt.springreact.services;

import com.tnt.springreact.model.Post;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    List<Post> listPost();

    ResponseEntity<?> findById(Long postId);

    Post savePost(Post post);

    void deletePost(Long postId);
}


