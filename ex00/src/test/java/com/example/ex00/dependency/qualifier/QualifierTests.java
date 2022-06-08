package com.example.ex00.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class QualifierTests {
    @Qualifier("desktop")
    @Autowired
    private Computer computer;

    @Test
    public void quailifierTest(){
        log.info("----------------");
        log.info("computer : "+ computer.getScreenWidth());
        log.info("----------------");
    }
}
