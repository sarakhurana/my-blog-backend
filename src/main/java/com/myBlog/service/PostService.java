package com.myBlog.service;

import com.myBlog.repository.PostRepository;
import com.myBlog.entity.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private PostRepository postRepository;

    PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostResponse> fetchAllPosts() {
        return PostRepository.getAllPosts();
    }

    public void saveNewPost(PostResponse postResponse) {
        if (postResponse != null)
            PostRepository.savePost(postResponse);
    }

}
