package com.example.member.service;

import com.example.member.dto.MemberDTO;
import com.example.member.dto.UserDTO;
import com.example.member.entity.MemberEntity;
import com.example.member.entity.UserEntity;
import com.example.member.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO login(UserDTO userDTO){
        Optional<UserEntity> byUserId = userRepository.findByUserId(userDTO.getUserId());
        if(byUserId.isPresent()){
            //조회 결과가 있음
            UserEntity userEntity = byUserId.get();
            if(userEntity.getUserPassword().equals(userDTO.getUserPassword())){
                //entity -> dto 변환 후 리턴
                UserDTO dto = UserDTO.toUserDTO(userEntity);
                return dto;
            }else{
                return null;
            }
        }else{
            //조회 결과가 없음
            return null;
        }
    }
}
