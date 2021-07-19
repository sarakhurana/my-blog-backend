package com.myBlog.service;

import com.myBlog.repository.PostRepository;
import com.myBlog.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<Post> fetchAllPosts() {
        return postRepository.findAll();
    }

    public Boolean saveNewPost(Post post) {
        if (post != null) {
            postRepository.save(post);
            return true;
        }
        return false;
    }
}
