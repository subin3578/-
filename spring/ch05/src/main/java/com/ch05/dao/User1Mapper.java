package com.ch05.dao;

import com.ch05.dto.User1DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// Mybatis scanning을 위해 @configuration이 아닌 @Mapper 선언
@Mapper
public interface User1Mapper {

    public void insertUser1(User1DTO dto);
    public User1DTO selectUser1(String uid);
    public List<User1DTO> selectUser1s();
    public void updateUser1(User1DTO dto);
    public void deleteUser1(String uid);

}
