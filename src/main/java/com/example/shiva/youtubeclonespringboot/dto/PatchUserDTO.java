package com.example.shiva.youtubeclonespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchUserDTO {

    private String firstName;
    private String lastName;
    private String password;

}
