package com.timeline.map.repository;

import com.timeline.map.model.TimeLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class TimeLineRepositoryTest {

    @Autowired
    private TimeLineRepository timeLineRepository;

    @Test
    @DisplayName("타임 라인 저장")
    void saveTimeLine() {
        TimeLine timeLine = new TimeLine();
        timeLine.setLatitude(new BigDecimal("440.0123"));
        timeLine.setLongitude(new BigDecimal("211.2646"));
        timeLine.setName("jongdae");

        timeLineRepository.save(timeLine);
    }
    
    @Test
    @DisplayName("타임 라인 가져오기")
    void getTimeLine() {
        List<TimeLine> timeLines = timeLineRepository.findAll();
        for (TimeLine timeLine:
             timeLines) {
            System.out.println(timeLine.toString());
        }
    }

}
