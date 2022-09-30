package com.timeline.map.service.impl;


import com.timeline.map.model.TimeLine;
import com.timeline.map.repository.TimeLineRepository;
import com.timeline.map.service.TimeLineService;

import java.time.LocalDateTime;
import java.util.List;

public class TimeLineServiceImpl implements TimeLineService {

    private final TimeLineRepository timeLineRepository;

    public TimeLineServiceImpl(TimeLineRepository timeLineRepository) {
        this.timeLineRepository = timeLineRepository;
    }

    @Override
    public List<TimeLine> saveTimeLine(List<TimeLine> timeLines) {
        return timeLineRepository.saveAll(timeLines);
    }

    @Override
    public List<TimeLine> getTimeLineByName(String name) {
        return timeLineRepository.getAllByName(name);
    }

    @Override
    public List<TimeLine> getTimeLineByNameWithDate(String name, LocalDateTime dateTime) {
        return timeLineRepository.getAllByNameAndRegDate(name, dateTime);
    }
}
