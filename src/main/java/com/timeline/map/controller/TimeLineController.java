package com.timeline.map.controller;

import com.timeline.map.domain.ResponseMessage;
import com.timeline.map.service.TimeLineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeLineController {

    private final TimeLineService timeLineService;

    public TimeLineController(TimeLineService timeLineService) {
        this.timeLineService = timeLineService;
    }


    @PostMapping("/timeline")
    ResponseEntity<ResponseMessage> saveTimeline(){

        return null;
    }

}
