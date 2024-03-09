package com.soloworld.blog.service;

import com.soloworld.blog.dto.PostInput;
import com.soloworld.blog.dto.PostResponse;

import java.util.List;

public interface IBlogService {

    List<PostResponse> getAllPost();

    PostResponse getPost(Long id);

    PostResponse createPost(PostInput postInput);

    PostResponse updatePost(Long postid, PostInput postInput);

    Boolean deletePost(Long postId);


}
