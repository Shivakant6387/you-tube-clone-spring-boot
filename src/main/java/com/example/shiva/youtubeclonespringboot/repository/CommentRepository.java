package com.example.shiva.youtubeclonespringboot.repository;

import com.example.shiva.youtubeclonespringboot.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

        List<Comment> findAllByFilm_Id(Long id);
}
