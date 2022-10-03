package com.timeline.map.controller;

import com.timeline.map.domain.ResponseMessage;
import com.timeline.map.domain.TimeLineVO;
import com.timeline.map.service.TimeLineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "TimeLine", description = "타임라인 API")
@RestController
public class TimeLineController {

    private final TimeLineService timeLineService;

    public TimeLineController(TimeLineService timeLineService) {
        this.timeLineService = timeLineService;
    }


    @Operation(summary = "save timeline", description = "현재 위치(위도, 경도)를 저장한다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
    })
    @Parameters({
            @Parameter(name = "latitude", description = "위도", example = "37.5666805"),
            @Parameter(name = "longitude", description = "경도", example = "126.9784147"),
    })
    @PostMapping("/timeline")
    ResponseEntity<ResponseMessage> saveTimeLine(@RequestBody TimeLineVO timeLineVO) {
        timeLineService.saveTimeLine(timeLineVO);

        return new ResponseEntity<>(new ResponseMessage(null, "타임라인을 저장했습니다"), HttpStatus.OK);
    }


    @Operation(summary = "get all timeline", description = "전체 타임라인을 가져온다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
    })
    @GetMapping("/timeline")
    ResponseEntity<ResponseMessage> getAllTimeLine() {
        return new ResponseEntity<>(new ResponseMessage(timeLineService.getAllTimeLine(), "전체 타임라인을 가져왔습니다"), HttpStatus.OK);
    }

    @Operation(summary = "get timeline by regdate", description = "해당 날짜의 타임라인을 가져온다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
    })
    @Parameters({
            @Parameter(name = "regDate", description = "등록일", example = "2022-10-03"),
    })
    @GetMapping("/timeline/{regDate}")
    ResponseEntity<ResponseMessage> getTimeLineByRegDate(@PathVariable String regDate) {
        return new ResponseEntity<>(new ResponseMessage(timeLineService.getTimeLineByDate(regDate), regDate + " 타임라인을 가져왔습니다"), HttpStatus.OK);
    }


}
