package com.example.shiva.youtubeclonespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Long id;
    private Long filmId;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String content;
    private int likes;
    private int dislikes;


    public CommentDTO(Long id, Long filmId, Long userId, String content, int likes, int dislikes) {
        this.id = id;
        this.filmId = filmId;
        this.userId = userId;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
    }
}
