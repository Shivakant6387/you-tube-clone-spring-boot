package com.example.shiva.youtubeclonespringboot.mapper;

import com.example.shiva.youtubeclonespringboot.dto.FilmDTO;
import com.example.shiva.youtubeclonespringboot.entity.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FilmMapper {

    @Mappings({
            @Mapping(target = "channel", source = "channel.name")
    })
    FilmDTO toFilmDTO(Film film);

    List<FilmDTO> toFilmDTO(Collection<Film> films);
}
