package com.myBlog.repository;

import com.myBlog.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryDBImpl implements PostRepositoryDB {
    List<Post> postsArray = new ArrayList<>();

    @Override
    public List<Post> getAllPosts() {
        return postsArray;
    }

    @Override
    public Optional<Post> savePost(Post post) {
        postsArray.add(post);
        return Optional.ofNullable(post);
    }

    @Override
    public void deleteAllEntries() {
        postsArray.clear();
    }

    @Override
    public void deletePost(String id) {
        postsArray.removeIf(post -> post.getPostId() == id);
    }
}
