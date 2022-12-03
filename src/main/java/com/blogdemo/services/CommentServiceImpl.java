package com.blogdemo.services;

import com.blogdemo.dto.CommentDto;
import com.blogdemo.entities.Comment;
import com.blogdemo.entities.Post;
import com.blogdemo.mapper.CommentMapper;
import com.blogdemo.repository.CommentRepository;
import com.blogdemo.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class CommentServiceImpl implements CommentService {

        private CommentRepository commentRepository;
        private PostRepository postRepository;

        public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
            this.commentRepository = commentRepository;
            this.postRepository = postRepository;
        }

        @Override
        public void createComment(String postUrl, CommentDto commentDto) {
            Post post = postRepository.findByUrl(postUrl).get();
            Comment comment = CommentMapper.mapToComment(commentDto);
            comment.setPost(post);
            commentRepository.save(comment);
        }

        @Override
        public List<CommentDto> getComments() {
            List<Comment> comments =  commentRepository.findAll();
            return comments.stream().map(CommentMapper::mapToCommentDto).collect(Collectors.toList());
        }

        @Override
        public void deleteComment(long commentId) {

            commentRepository.deleteById(commentId);
        }
    }




