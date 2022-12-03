package com.blogdemo.services;

import com.blogdemo.dto.CommentDto;

import java.util.List;

public interface CommentService {
    void createComment(String postUrl, CommentDto commentDto);
    List<CommentDto> getComments();

    public void deleteComment(long commentId);
}

