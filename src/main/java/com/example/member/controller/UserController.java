package com.example.member.controller;

import com.example.member.dto.UserDTO;
import com.example.member.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class UserController {

    //생성자 주입
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO, HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDTO loginResult = userService.login(userDTO);
        if(loginResult != null){
            //System.out.println(loginResult.getUserId());
            //System.out.println(loginResult.getUserPassword());
            session.setAttribute("loginUserId", loginResult.getUserId());
            return new ResponseEntity<>("success" ,HttpStatus.OK);
        }else{
            return null;
        }
    }

    //세션 테스트를 해보자
    @GetMapping(value = "/loginTest")
    public Map<String, String> loginTest(HttpServletRequest request) {
        Map<String, String> sessionResult = new HashMap<>();
        HttpSession session = request.getSession();
        sessionResult.put("sessionId", (String) session.getAttribute("loginUserId"));
        //System.out.println("sessionResult.get(\"sessionId\") = " + sessionResult.get("sessionId"));
        System.out.println(session.getAttribute("loginUserId"));
        return sessionResult;
    }
}