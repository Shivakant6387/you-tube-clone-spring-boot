package com.example.shiva.youtubeclonespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;

    @NonNull
    private String name;
}
