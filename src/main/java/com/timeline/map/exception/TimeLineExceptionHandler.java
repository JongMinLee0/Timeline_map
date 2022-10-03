package com.timeline.map.exception;

import com.timeline.map.domain.ResponseMessage;
import com.timeline.map.util.SendTelegram;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TimeLineExceptionHandler {

    private final SendTelegram sendTelegram;


    public TimeLineExceptionHandler(SendTelegram sendTelegram) {
        this.sendTelegram = sendTelegram;
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ResponseMessage> exceptionHandler(Exception e) {
        sendTelegram.sendMessage(ExceptionUtils.getStackTrace(e));
        ResponseMessage responseMessage = new ResponseMessage(null, e.getMessage());
        responseMessage.setStatus(500);

        return new ResponseEntity<>(responseMessage, HttpStatus.BAD_REQUEST);
    }


}
