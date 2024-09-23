package com.ch10.service;

import com.ch10.dto.UserDTO;
import com.ch10.entity.User;
import com.ch10.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void insertUser(UserDTO userDTO) {
        //회원가입
       String encoded = passwordEncoder.encode(userDTO.getPass());
       userDTO.setPass(encoded);

        User user = userDTO.toEntity();
        userRepository.save(userDTO.toEntity());
    }

    public UserDTO selectUser(String uid) {
        Optional<User> optUser = userRepository.findById(uid);

        if(optUser.isPresent()) {
            User user = optUser.get();
            return user.toDTO();
        }
        return null;
    }
}
