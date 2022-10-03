package com.timeline.map.domain;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseMessage {

    private int status;
    private Object data;
    private String message;
    private LocalDateTime time;

    public ResponseMessage(Object data, String message) {
        this.data = data;
        this.message = message;
        this.status = HttpStatus.OK.value();
        this.time = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
