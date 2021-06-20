package com.myBlog.repository;

import com.myBlog.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PostRepositoryDB {
    List<Post> postsArray = new ArrayList<>();

    List<Post> getAllPosts();

    Optional<Post> savePost(Post post);

    void deleteAllEntries();

    void deletePost(String id);
}
