package com.ch05.dao;

import com.ch05.dto.User3DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User3Mapper {

    public void insertUser3(User3DTO dto);
    public User3DTO selectUser3(String uid);
    public List<User3DTO> selectUser3s();
    public void updateUser3(User3DTO dto);
    public void deleteUser3(String uid);

}
