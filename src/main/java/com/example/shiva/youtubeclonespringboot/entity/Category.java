package com.example.shiva.youtubeclonespringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table  (name = "categories")
@Entity
public class Category extends AbstractEntity {

//    @OneToMany(mappedBy = "category")
//    private Set<Film> films = new HashSet<>();

    private String name;

    public Category(Long id, String name) {
        super(id);
        this.name = name;
    }
}
