package com.myBlog.repository;

import com.myBlog.response.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository {

    List<PostResponse> postsArray = new ArrayList<>();

    static List<PostResponse> getAllPosts() {
        return postsArray;
    }

    static void savePost(PostResponse postResponse) {
        postsArray.add(postResponse);
    }

    static void deleteAllEntries(){
        postsArray.clear();
    }

     static void deletePost(String id){
        postsArray.removeIf(post -> post.getPostId() == id);
    }

}
