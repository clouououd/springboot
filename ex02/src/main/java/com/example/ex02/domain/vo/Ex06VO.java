package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@Data
public class Ex06VO {
    private String name;

    public Calendar getNow(){
        return Calendar.getInstance();
    }

    public Date getStartTime() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.parse("09:00");
    }

    public Date getEndTime() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.parse("18:00");
    }

}
