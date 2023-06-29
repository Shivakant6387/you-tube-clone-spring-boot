package com.example.shiva.youtubeclonespringboot.repository;

import com.example.shiva.youtubeclonespringboot.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {
    List<Film> findAllByChannel_Id(Long id);

}
