package com.soloworld.blog.service;

import com.soloworld.blog.dto.PostInput;
import com.soloworld.blog.dto.PostResponse;
import com.soloworld.blog.entity.Post;
import com.soloworld.blog.repository.CommentRepository;
import com.soloworld.blog.repository.PostRepository;
import com.soloworld.blog.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    private PostRepository postRepository;

    private UserRepository userRepository;

    private CommentRepository commentRepository;

    public BlogService(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<PostResponse> getAllPost() {
        return  convertToPostDTO(postRepository.findAll());
    }

    private List<PostResponse> convertToPostDTO(List<Post> all) {
        if(CollectionUtils.isEmpty(all)) {
            return Collections.emptyList();
        }
       return all.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PostResponse convertToDTO(Post post) {
        if(post == null) {
            return null;
        }
        return new PostResponse(post.getPost_id() ,post.getContent());
    }

    @Override
    public PostResponse getPost(Long id) {
        return convertToDTO(postRepository.findById(id).orElse(null));
    }

    @Override
    public PostResponse createPost(PostInput postInput) {
        if (postInput.content() == null || postInput.content().isEmpty()) {
            return null;
        }

        Post post = new Post();
        post.setContent(postInput.content());
        return convertToDTO(postRepository.save(post));
    }

    @Override
    public PostResponse updatePost(Long postid, PostInput postInput) {
        if (postInput.content() == null || postInput.content().isEmpty()) {
            return null;
        }
        Optional<Post> post = postRepository.findById(postid);
        if (post.isPresent()) {
            Post post1 = post.get();
            post1.setContent(postInput.content());
            return convertToDTO(postRepository.save(post1));
        }
        return null;
    }

    @Override
    public Boolean deletePost(Long postId) {
        postRepository.deleteById(postId);
        return true;
    }
}
