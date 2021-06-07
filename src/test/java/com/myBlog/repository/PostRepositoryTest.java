package com.myBlog.repository;


import com.myBlog.response.PostResponse;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Before
    public void setup() {
        postRepository.deleteAll();
    }

    @Test
    public void savePostShouldAddANewPostToPostArray() {
        PostResponse postResponse = new PostResponse("3", "New Post");

        PostRepository.savePost(postResponse);
        List<PostResponse> allPosts = PostRepository.getAllPosts();

        assertEquals(allPosts.size(),1);
    }
        @Test
    public void getAllPostsShouldReturnAllPosts() {
        PostResponse postResponse1 = new PostResponse("3", "New Post");
        PostResponse postResponse2 = new PostResponse("2", "Hello, New Post");
        PostRepository.savePost(postResponse1);
        PostRepository.savePost(postResponse2);

        List<PostResponse> allPosts = PostRepository.getAllPosts();

        assertEquals(allPosts.size(),2);
    }
}
