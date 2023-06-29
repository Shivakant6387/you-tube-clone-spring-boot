package com.example.shiva.youtubeclonespringboot.mapper;

import com.example.shiva.youtubeclonespringboot.dto.CommentDTO;
import com.example.shiva.youtubeclonespringboot.entity.Comment;
import com.example.shiva.youtubeclonespringboot.entity.Film;
import com.example.shiva.youtubeclonespringboot.entity.User;
import com.example.shiva.youtubeclonespringboot.exception.FilmNotFoundException;
import com.example.shiva.youtubeclonespringboot.exception.UserNotFoundException;
import com.example.shiva.youtubeclonespringboot.repository.FilmRepository;
import com.example.shiva.youtubeclonespringboot.repository.UserRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class CommentMapper {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FilmRepository filmRepository;
    @Mappings({
            @Mapping(target = "filmId", source = "film.id"),
            @Mapping(target = "userId", source = "user.id")
    })
    public abstract CommentDTO toCommentDTO(Comment comment);

    public abstract List<CommentDTO> toCommentDTO(Collection<Comment> comments);

    public Comment toCommentEntity(CommentDTO commentDTO) {
        Comment comment = new Comment();

        User user = userRepository.findById(commentDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        comment.setUser(user);

        Film film = filmRepository.findById(commentDTO.getFilmId())
                .orElseThrow(() -> new FilmNotFoundException("Film not found"));
        comment.setFilm(film);

        comment.setLikes(commentDTO.getLikes());
        comment.setDislikes(commentDTO.getDislikes());

        comment.setContent(commentDTO.getContent());
        comment.setUpdatedAt(commentDTO.getUpdatedAt());
        comment.setCreatedAt(commentDTO.getCreatedAt());

        return comment;
    }
}
