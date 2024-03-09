package com.soloworld.blog.entity;

import jakarta.persistence.*;
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private User user;

    private String comment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id" ,nullable = false)
    private Post post;

    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(Long comment_id) {
        this.comment_id = comment_id;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
