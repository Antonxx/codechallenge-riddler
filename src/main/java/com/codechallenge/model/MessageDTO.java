package com.codechallenge.model;

public class MessageDTO {
    private String content;

    public MessageDTO(){

    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }


    @Override
    public String toString() {
        return content;
    }

}