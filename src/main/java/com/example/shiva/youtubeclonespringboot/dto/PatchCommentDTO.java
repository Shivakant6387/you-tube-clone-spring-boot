package com.example.shiva.youtubeclonespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchCommentDTO {
    private String content;
    private LocalDateTime updatedAt;

}
