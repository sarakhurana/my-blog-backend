package com.myBlog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="blog_posts")
public class Post {
    @Id
    @Column(name="post_id")
    private String postId;
    @Column(name="post_body")
    private String body;

}