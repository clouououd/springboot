package com.example.board.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void isIdTest(){
        log.info("중복확인 결과 : "+ userMapper.isId(5L));
        // Test에서는 return을 사용할 수 없다. 리턴 사용시 No test were found. 에러가 나옴.
    };

}
