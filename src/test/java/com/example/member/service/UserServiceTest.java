package com.example.member.service;

import com.example.member.dto.UserDTO;
import com.example.member.entity.UserEntity;
import com.example.member.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    void login(){
        UserEntity user = new UserEntity();
        user.setUserEmail("chrhfoq123@naver.com");
        user.setUserId("chrhfoq123");
        user.setUserPassword("1234");

        userRepository.save(user);

        //serDTO userDTO = userService.login();
    }
}
