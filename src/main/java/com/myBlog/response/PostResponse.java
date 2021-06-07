package com.myBlog.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private String postId;
    private String postBody;

//    public PostResponse(String id, String body) {
//        this.postBody = body;
//        this.postId = id;
//    }
}