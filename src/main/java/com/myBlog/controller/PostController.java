package com.myBlog.controller;

import com.myBlog.entity.Post;
import com.myBlog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/my-blog")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = postService.fetchAllPosts();
        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> savePosts(@RequestBody Post post) {
        postService.saveNewPost(post);
        return new ResponseEntity(HttpStatus.OK);
    }
}
