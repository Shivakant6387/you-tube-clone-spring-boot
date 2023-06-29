package com.example.shiva.youtubeclonespringboot.controller;

import com.example.shiva.youtubeclonespringboot.ApiInformation;
import com.example.shiva.youtubeclonespringboot.dto.CategoryDTO;
import com.example.shiva.youtubeclonespringboot.dto.PatchCategoryDTO;
import com.example.shiva.youtubeclonespringboot.mapper.CategoryMapper;
import com.example.shiva.youtubeclonespringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    @Autowired
    public CategoryController(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping("/categories")
    public List<CategoryDTO> getCategories() {
        return categoryMapper.toCategoryDTO(categoryService.getCategories());
    }

    @PostMapping("/categories")
    public CategoryDTO postCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryMapper.toCategoryDTO(categoryService.postCategory(categoryMapper.toCategoryEntity(categoryDTO)));
    }

    @DeleteMapping("/categories/{id}")
    public ApiInformation deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ApiInformation("Delete sucessful.", HttpStatus.OK.value());
    }

    @PatchMapping("/categories/{id}")
    public CategoryDTO updateCategoryById(@PathVariable Long id, @Validated @RequestBody PatchCategoryDTO patchCategoryDTO) {
        return categoryMapper.toCategoryDTO(categoryService.updateCategoryById(id, patchCategoryDTO));
    }
}
