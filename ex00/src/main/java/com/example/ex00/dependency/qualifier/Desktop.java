package com.example.ex00.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("desktop")
public @Primary class Desktop implements Computer{
    @Override
    public int getScreenWidth() {
        return 1920;
    }
}
