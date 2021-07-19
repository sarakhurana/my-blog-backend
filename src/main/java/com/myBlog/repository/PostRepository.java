package com.myBlog.repository;

import com.myBlog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, String>{
//    @Override
//    List<Post> findAll();
//
//    @Override
//    <S extends Post> S save(S post);
//
//    @Override
//    void deleteById(String postId);
//
//    @Override
//    void deleteAll();
}
