package com.tnt.springreact.services;

import com.tnt.springreact.model.Post;
import com.tnt.springreact.repository.PostRepository;
import com.tnt.springreact.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public ResponseEntity<?> findById(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        return postOptional.map(post -> ResponseEntity.ok().body(post)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Post> listPost() {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}


