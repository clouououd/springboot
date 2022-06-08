package com.example.board.domain.dao;

import com.example.board.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserDAO {
    private final UserMapper userMapper;

    // 아이디 중복 체크
    public int idCheck(Long userId){
        log.info("중복체크하는 아이디 ..." + userId);
        return userMapper.isId(userId);
    }

}
