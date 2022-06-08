package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class EnforceVO {
    private int offenceBefore;
    private int change;

    public int getOffenceAfter(){
        return offenceBefore + change;
    };
}
