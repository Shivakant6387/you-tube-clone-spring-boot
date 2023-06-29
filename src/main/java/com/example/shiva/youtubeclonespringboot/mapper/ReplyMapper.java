package com.example.shiva.youtubeclonespringboot.mapper;

import com.example.shiva.youtubeclonespringboot.dto.ReplyDTO;
import com.example.shiva.youtubeclonespringboot.entity.Comment;
import com.example.shiva.youtubeclonespringboot.entity.Reply;
import com.example.shiva.youtubeclonespringboot.entity.User;
import com.example.shiva.youtubeclonespringboot.exception.CommentNotFoundException;
import com.example.shiva.youtubeclonespringboot.exception.UserNotFoundException;
import com.example.shiva.youtubeclonespringboot.repository.CommentRepository;
import com.example.shiva.youtubeclonespringboot.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReplyMapper {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "commentId", source = "comment.id")
    })
    public abstract ReplyDTO toReplyDTO(Reply reply);

    public abstract List<ReplyDTO> toReplyDTO(Collection<Reply> reply);

    public Reply toReplyEntity(ReplyDTO replyDTO) {
        Reply reply = new Reply();

        User user = userRepository.findById(replyDTO.getUserId()).orElseThrow(() -> new UserNotFoundException("User nor found."));
        reply.setUser(user);

        Comment comment = commentRepository.findById(replyDTO.getCommentId()).orElseThrow(() -> new CommentNotFoundException("Comment nor found."));
        reply.setComment(comment);

        reply.setContent(replyDTO.getContent());
        reply.setCreatedAt(replyDTO.getCreatedAt());
        reply.setDislikes(replyDTO.getDislikes());
        reply.setLikes(replyDTO.getLikes());

        return reply;
    }
}