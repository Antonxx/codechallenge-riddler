package com.codechallenge.model;

import java.sql.Timestamp;

public class MessageTimestamp extends MessageDTO {
    private Timestamp time;

    public MessageTimestamp(String content, Timestamp time) {
        super(content);
        this.time = time;
    }

    public Timestamp getTime() {
        return time;
    }

}
