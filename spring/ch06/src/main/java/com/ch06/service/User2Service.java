package com.ch06.service;

import com.ch06.dao.User1Mapper;
import com.ch06.dao.User2Mapper;
import com.ch06.dto.User1DTO;
import com.ch06.dto.User2DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User2Service {
    // 테스트 케이스 작성 : 마우스 오른버튼 > Generate ... > test ... 클릭해서 테스트 작성
    private final User2Mapper user2Mapper;

    public void insertUser2(User2DTO user2DTO){
        user2Mapper.insertUser2(user2DTO);
    };
    public User2DTO selectUser2(String uid){
        return user2Mapper.selectUser2(uid);
    };
    public List<User2DTO> selectUser2s(){
        return user2Mapper.selectUser2s();
    };
    public void updateUser2(User2DTO user2DTO){
        user2Mapper.updateUser2(user2DTO);
    };
    public void deleteUser2(String uid){
        user2Mapper.deleteUser2(uid);
    };
}
