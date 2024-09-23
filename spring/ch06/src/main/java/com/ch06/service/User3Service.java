package com.ch06.service;

import com.ch06.dao.User3Mapper;
import com.ch06.dto.User3DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@RequiredArgsConstructor
@Service
public class User3Service {

    private final User3Mapper user3Mapper;

    public void insertUser3(User3DTO user3DTO){
        user3Mapper.insertUser3(user3DTO);
    };
    public User3DTO selectUser3(String uid){
        return user3Mapper.selectUser3(uid);
    };
    public List<User3DTO> selectUser3s(){
        return user3Mapper.selectUser3s();
    };
    public void updateUser3(User3DTO user3DTO){
        user3Mapper.updateUser3(user3DTO);
    }
    public void deleteUser3(String uid){
        user3Mapper.deleteUser3(uid);
    }

}
