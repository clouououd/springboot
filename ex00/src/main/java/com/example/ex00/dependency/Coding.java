package com.example.ex00.dependency;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public final class Coding {

    private Computer computer;

//    @Autowired
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}
