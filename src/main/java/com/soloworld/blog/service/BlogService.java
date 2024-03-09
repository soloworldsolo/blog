package com.soloworld.blog.service;

import com.soloworld.blog.dto.PostInput;
import com.soloworld.blog.dto.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {


    @Override
    public List<PostResponse> getAllPost() {
        return null;
    }

    @Override
    public PostResponse getPost(Long id) {
        return null;
    }

    @Override
    public PostResponse createPost(PostInput postInput) {
        return null;
    }

    @Override
    public PostResponse updatePost(Long postid, PostInput postInput) {
        return null;
    }

    @Override
    public Boolean deletePost(Long postId) {
        return null;
    }

}
