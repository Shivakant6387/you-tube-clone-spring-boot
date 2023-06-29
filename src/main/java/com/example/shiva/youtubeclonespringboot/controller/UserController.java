package com.example.shiva.youtubeclonespringboot.controller;

import com.example.shiva.youtubeclonespringboot.ApiInformation;
import com.example.shiva.youtubeclonespringboot.dto.PatchUserDTO;
import com.example.shiva.youtubeclonespringboot.dto.UserDTO;
import com.example.shiva.youtubeclonespringboot.entity.User;
import com.example.shiva.youtubeclonespringboot.mapper.UserMapper;
import com.example.shiva.youtubeclonespringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/users")
    public List<UserDTO> getUser(){
        return userMapper.toUserDTO(userService.findAll());
    }

    @GetMapping("/users/{user_id}")
    public UserDTO getUserById(@PathVariable("user_id") Long id){
        return userMapper.toUserDTO(userService.findUserById(id));
    }

    @PostMapping("/users")
    public UserDTO postUser(@RequestBody UserDTO user){
        return userMapper.toUserDTO(userService.saveUser(userMapper.toUserEntity(user)));
    }

    @DeleteMapping("/users/{id}")
    public ApiInformation deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ApiInformation("Deleted user", HttpStatus.OK.value());
    }

    @PatchMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, @Validated @RequestBody PatchUserDTO userDTO) {
        return userService.updateUserById(id, userDTO);
    }
}
