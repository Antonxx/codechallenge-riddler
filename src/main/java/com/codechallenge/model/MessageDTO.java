package com.codechallenge.model;


public class MessageDTO {
    protected String content;

    public MessageDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }

    @Override
    public boolean equals(Object msg) {

        return msg instanceof MessageDTO ? ((MessageDTO) msg).getContent().equals(content) : false;

    }

}