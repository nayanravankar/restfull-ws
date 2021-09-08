package com.restws.ws.restfullws.bean;

import java.util.Date;

public class ResponseException {
    private String msg;
    private String details;
    private Date timestamp;

    public ResponseException(String msg, String details, Date timestamp) {
        this.msg = msg;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
