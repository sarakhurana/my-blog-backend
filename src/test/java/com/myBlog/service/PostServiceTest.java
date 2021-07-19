package com.myBlog.service;

import com.myBlog.repository.PostRepository;
import com.myBlog.entity.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    private PostService postService;

    @Before
    public void setUp() {
        postService = new PostService(postRepository);
        postRepository.deleteAll();
    }

    @Test
    public void shouldFetchAllPosts() {
        Post post = new Post("1", "New Post");

        when(postRepository.findAll()).thenReturn(List.of(post));
        List<Post> allPosts = postService.fetchAllPosts();

        assertEquals(allPosts, List.of(post));
    }

    @Test
    public void shouldSaveGivenPost() {
        Post post = new Post("1", "New Post");

        when(postRepository.save(any())).thenReturn(Optional.of(post));
        postService.saveNewPost(post);

        verify(postRepository).save(eq(post));
        verify(postRepository, times(1)).save(any(Post.class));

    }
}