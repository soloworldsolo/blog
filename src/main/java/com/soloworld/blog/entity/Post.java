package com.soloworld.blog.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    private Long author_id;
    private String content;
    @OneToMany(mappedBy = "post")
    private Set<Comment> comments;

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
