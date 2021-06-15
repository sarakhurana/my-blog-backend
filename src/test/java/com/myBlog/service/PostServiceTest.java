package com.myBlog.service;

import com.myBlog.repository.PostRepository;
import com.myBlog.response.PostResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    private PostService postService;

    @Before
    public void setUp() {
        postService = new PostService(postRepository);
        PostRepository.deleteAllEntries();
    }

    @Test
    public void shouldFetchAllPosts() {
        PostResponse postResponse = new PostResponse("1", "New Post");

        PostRepository.savePost(postResponse);
        List<PostResponse> allPosts = postService.fetchAllPosts();

        assertEquals(allPosts, List.of(postResponse));
    }

    @Test
    public void shouldSaveGivenPost() {
        PostResponse postResponse = new PostResponse("1", "New Post");
        postService.saveNewPost(postResponse);

        List<PostResponse> allPosts = postService.fetchAllPosts();
        assertEquals(allPosts, List.of(postResponse));

    }
}