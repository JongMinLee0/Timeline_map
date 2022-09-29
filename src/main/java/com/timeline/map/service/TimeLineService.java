package com.timeline.map.service;

import com.timeline.map.model.TimeLine;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TimeLineService {

    List<TimeLine> saveTimeLine(List<TimeLine> timeLines);

    List<TimeLine> getTimeLineByName(String name);

    List<TimeLine> getTimeLineByNameWithDate(String name, LocalDateTime dateTime);

}
