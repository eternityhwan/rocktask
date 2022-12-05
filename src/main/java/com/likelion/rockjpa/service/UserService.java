package com.likelion.rockjpa.service;


import com.likelion.rockjpa.domain.User;
import com.likelion.rockjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public String join(String userName, String password) {

        // 중복체크(유저네임)
        userRepository.findByUserName(userName)
            .ifPresent(user -> {
                throw new RuntimeException(userName + "는 중복되는 이름입니다.");
            });

        // 저장
        User user = User.builder()
            .userName(userName)
            .password(password)
            .build();
        userRepository.save(user);


        // 중복체크하려면 DB에 다녀와야지

        return "성공";
    }
}
