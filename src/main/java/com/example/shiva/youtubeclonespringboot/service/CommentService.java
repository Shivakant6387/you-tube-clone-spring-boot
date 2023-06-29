package com.example.shiva.youtubeclonespringboot.service;

import com.example.shiva.youtubeclonespringboot.dto.PatchCommentDTO;
import com.example.shiva.youtubeclonespringboot.entity.Comment;
import com.example.shiva.youtubeclonespringboot.exception.CommentNotFoundException;
import com.example.shiva.youtubeclonespringboot.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public List<Comment> getCommentsByFilmId(Long id) {
        return commentRepository.findAllByFilm_Id(id);
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getCommentById(Long id){
        return commentRepository.findById(id)
                .orElseThrow(()-> new CommentNotFoundException("There is no exist comment like this."));
    }

    public Comment updateCommentById(Long id, PatchCommentDTO patchCommentDTO) {
        Comment comment = getCommentById(id);
        comment.setContent(patchCommentDTO.getContent());
        comment.setUpdatedAt(patchCommentDTO.getUpdatedAt());
        return commentRepository.save(comment);
    }

    public void deleteCommentById(Long id){
        commentRepository.deleteById(id);
    }
}
