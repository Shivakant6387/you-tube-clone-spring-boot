package com.example.shiva.youtubeclonespringboot.controller;

import com.example.shiva.youtubeclonespringboot.ApiInformation;
import com.example.shiva.youtubeclonespringboot.entity.Category;
import com.example.shiva.youtubeclonespringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryControllerWithoutMapper {

    private CategoryService categoryService;

    @Autowired
    public CategoryControllerWithoutMapper(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories2")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }


    @DeleteMapping("/categories2/{id}")
    public ApiInformation deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ApiInformation("Delete sucessful.", HttpStatus.OK.value());
    }

}
