package com.blogdemo.services;

import com.blogdemo.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();

    void createPost(PostDto postDto);

    PostDto findPostById(Long postId);

    void updatePost(PostDto postDto);

    void deletePost(Long postId);

    public PostDto findPostByUrl(String postUrl);

    List<PostDto> searchPosts(String query);
}
