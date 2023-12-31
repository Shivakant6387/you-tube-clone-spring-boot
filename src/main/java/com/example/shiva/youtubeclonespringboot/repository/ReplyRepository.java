package com.example.shiva.youtubeclonespringboot.repository;

import com.example.shiva.youtubeclonespringboot.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findAllByCommentId(Long id);
    List<Reply> findAllByUser_UserName(String s);
}
