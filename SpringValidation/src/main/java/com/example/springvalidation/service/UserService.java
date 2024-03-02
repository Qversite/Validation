package com.example.springvalidation.service;

import com.example.springvalidation.dto.UserDto;
import com.example.springvalidation.model.User;
import com.example.springvalidation.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public void save(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        userRepo.save(user);
    }
}
