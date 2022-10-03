package com.timeline.map.service.impl;


import com.timeline.map.domain.TimeLineVO;
import com.timeline.map.model.TimeLine;
import com.timeline.map.repository.TimeLineRepository;
import com.timeline.map.service.TimeLineService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TimeLineServiceImpl implements TimeLineService {

    private final TimeLineRepository timeLineRepository;

    public TimeLineServiceImpl(TimeLineRepository timeLineRepository) {
        this.timeLineRepository = timeLineRepository;
    }

    @Override
    public TimeLine saveTimeLine(TimeLineVO timeLines) {
        TimeLine timeLine = new TimeLine();
        timeLine.setLatitude(timeLines.getLatitude());
        timeLine.setLongitude(timeLines.getLongitude());
        return timeLineRepository.save(timeLine);
    }

    @Override
    public List<TimeLine> getAllTimeLine() {
        return timeLineRepository.findAll();
    }


    @Override
    public List<TimeLine> getTimeLineByDate(String regDate) {
        LocalDateTime startDate = new Timestamp(Date.valueOf(regDate).getTime()).toLocalDateTime();
        return timeLineRepository.findAllByRegDateBetween(startDate, startDate.plusDays(1));
    }

}
