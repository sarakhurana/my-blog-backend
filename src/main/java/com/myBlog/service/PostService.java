package com.myBlog.service;

import com.myBlog.repository.PostRepository;
import com.myBlog.entity.Post;
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

    public List<Post> fetchAllPosts() {
        return postRepository.getAllPosts();
    }

    public void saveNewPost(Post post) {
        if (post != null)
                postRepository.savePost(post);
    }

}
