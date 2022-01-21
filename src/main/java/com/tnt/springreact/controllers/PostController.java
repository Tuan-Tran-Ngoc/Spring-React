package com.tnt.springreact.controllers;
import com.tnt.springreact.model.Post;
import com.tnt.springreact.services.PostServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    private final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    PostServiceImpl postServiceImpl;

    @GetMapping("/post/list")
    List<Post>  list() {
        return postServiceImpl.listPost();
    }

    @GetMapping("/post/{id}")
    ResponseEntity<?> getPost(@PathVariable Long postId) {
        return postServiceImpl.findById(postId);
    }

    @PostMapping("/post")
    ResponseEntity<Post> createPost(@Valid @RequestBody Post post) throws URISyntaxException {
        Post newPost = postServiceImpl.savePost(post);
        return ResponseEntity.created(new URI("/api/post" + newPost.getId())).body(newPost);
    }

    @PutMapping("/post")
    ResponseEntity<Post> updatePost(@Valid @RequestBody Post post) {
        Post newPost = postServiceImpl.savePost(post);
        return ResponseEntity.ok().body(newPost);
    }

    @DeleteMapping("/post/{id}")
    ResponseEntity deletePost(@PathVariable Long postId) {
        postServiceImpl.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}
