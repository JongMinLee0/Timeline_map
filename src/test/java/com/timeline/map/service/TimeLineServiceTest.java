package com.timeline.map.service;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootTest
public class TimeLineServiceTest {



    @Test
    @DisplayName("regDate 파싱 테스트")
    void regDateToLocalDateTime() {
        String regDate = "2022-10-03";
        System.out.println("regDate : " + regDate);

        Date dateTime = Date.valueOf(regDate);
        System.out.println("dateTime : " + dateTime);

        LocalDateTime localDateTime = new Timestamp(dateTime.getTime()).toLocalDateTime();
        System.out.println("localDateTime : " + localDateTime.toString());
        localDateTime.plusDays(1);
        System.out.println("plusDate : " + localDateTime.plusDays(1));
    }


}
