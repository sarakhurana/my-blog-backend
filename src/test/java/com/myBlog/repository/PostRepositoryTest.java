package com.myBlog.repository;


import com.myBlog.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    public void setup() {
        postRepository.deleteAllEntries();
    }

    @Test
    public void savePostShouldAddANewPostToPostArray() {
        Post post = new Post("3", "New Post");

        postRepository.savePost(post);
        List<Post> allPosts = postRepository.getAllPosts();

        assertEquals(allPosts.size(), 1);
    }

    @Test
    public void getAllPostsShouldReturnAllPosts() {
        Post post1 = new Post("3", "New Post");
        Post post2 = new Post("2", "Hello, New Post");
        postRepository.savePost(post1);
        postRepository.savePost(post2);

        List<Post> allPosts = postRepository.getAllPosts();

        assertEquals(allPosts.size(), 2);
    }

    @Test
    public void deletePostShouldDeleteGivenPost() {
        Post post = new Post("1", "New Post");

        postRepository.savePost(post);
        List<Post> allPosts = postRepository.getAllPosts();

        assertEquals(allPosts.size(), 1);

        postRepository.deletePost(post.getPostId());
        List<Post> updatedPosts = postRepository.getAllPosts();

        assertEquals(updatedPosts.size(),0);
    }
}
