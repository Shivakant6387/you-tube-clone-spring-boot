package com.example.shiva.youtubeclonespringboot.service;

import com.example.shiva.youtubeclonespringboot.dto.PatchUserDTO;
import com.example.shiva.youtubeclonespringboot.entity.User;
import com.example.shiva.youtubeclonespringboot.exception.UserNotFoundException;
import com.example.shiva.youtubeclonespringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) { }
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Cant find user by id."));
    }

    public User updateUserById(Long id, PatchUserDTO patchUserDTO) {
        User user = findUserById(id);
        user.setFirstName(patchUserDTO.getFirstName());
        user.setLastName(patchUserDTO.getLastName());
        return userRepository.save(user);
    }
}
