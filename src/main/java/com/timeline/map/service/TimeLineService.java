package com.timeline.map.service;

import com.timeline.map.domain.TimeLineVO;
import com.timeline.map.model.TimeLine;

import java.util.List;

public interface TimeLineService {

    TimeLine saveTimeLine(TimeLineVO timeLines);

    List<TimeLine> getAllTimeLine();

    List<TimeLine> getTimeLineByDate(String regDate);

}
