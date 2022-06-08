package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {

    private long userId;
    private String userName;
    private String userPw;
    private String userRegisterDate;
}
