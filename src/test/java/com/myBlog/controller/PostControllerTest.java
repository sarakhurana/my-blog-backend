package com.myBlog.controller;

import com.myBlog.entity.Post;
import com.myBlog.repository.PostRepository;
import com.myBlog.service.PostService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PostController.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;


    @Test
    public void getPostsShouldReturnAllPosts() throws Exception {
        Post dummyPost = new Post("1", "Hello");

        when(postService.fetchAllPosts()).thenReturn(List.of(dummyPost));

        MockHttpServletResponse actualResponse = mockMvc
                .perform(get("/my-blog").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponse();

        String expectedResponse = "[{\"postId\":\"1\",\"postBody\":\"Hello\"}]";

        assertEquals(expectedResponse, actualResponse.getContentAsString());
    }

    @Test
    public void savePostShouldSavePost() throws Exception {
        Post dummyPost = new Post("1", "Hello");
        String post = "{\"postId\":\"1\",\"postBody\":\"Hello\"}";

        MockHttpServletResponse actualResponse = mockMvc
                .perform(post("/my-blog").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(post))
                .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), actualResponse.getStatus());
        verify(postService, times(1)).saveNewPost(dummyPost);

    }
}
